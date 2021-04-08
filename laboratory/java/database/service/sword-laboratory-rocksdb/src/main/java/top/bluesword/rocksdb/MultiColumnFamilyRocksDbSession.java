package top.bluesword.rocksdb;

import org.rocksdb.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 李林峰
 */
public class MultiColumnFamilyRocksDbSession implements AutoCloseable {

    private final RocksDB db;
    private final Map<String,ColumnFamilyHandle> columnFamilyHandleMap;

    static {
        RocksDB.loadLibrary();
    }

    public MultiColumnFamilyRocksDbSession(RocksDB db, Map<String, ColumnFamilyHandle> columnFamilyHandleMap) {
        this.db = db;
        this.columnFamilyHandleMap = columnFamilyHandleMap;
    }

    public static MultiColumnFamilyRocksDbSession init(String path, List<String> columnFamilyNames) throws RocksDBException {
        final ColumnFamilyOptions cfOpts = createDefaultColumnFamilyOptions();
        final DBOptions options = createDefaultDbOptions();
        final List<ColumnFamilyDescriptor> cfDescriptors = buildColumnFamilyDescriptors(columnFamilyNames, cfOpts);
        List<ColumnFamilyHandle> columnFamilyHandleList = new ArrayList<>();
        RocksDB db = openDb(path, cfOpts, options, cfDescriptors, columnFamilyHandleList);
        Map<String, ColumnFamilyHandle> columnFamilyHandleMap = drawColumnFamilyMap(columnFamilyNames, columnFamilyHandleList);
        return new MultiColumnFamilyRocksDbSession(db, columnFamilyHandleMap);
    }

    private static Map<String, ColumnFamilyHandle> drawColumnFamilyMap(List<String> columnFamilyNames, List<ColumnFamilyHandle> columnFamilyHandleList) {
        Map<String,ColumnFamilyHandle> columnFamilyHandleMap = new HashMap<>();
        for (int i = 0; i < columnFamilyNames.size(); i++) {
            columnFamilyHandleMap.put(columnFamilyNames.get(i),columnFamilyHandleList.get(i));
        }
        return columnFamilyHandleMap;
    }

    private static RocksDB openDb(String path,
                                  ColumnFamilyOptions cfOpts,
                                  DBOptions options,
                                  List<ColumnFamilyDescriptor> cfDescriptors,
                                  List<ColumnFamilyHandle> columnFamilyHandleList) throws RocksDBException {
        RocksDB db;
        try(cfOpts;options) {
            db = RocksDB.open(options,path, cfDescriptors, columnFamilyHandleList);
        }
        return db;
    }

    private static List<ColumnFamilyDescriptor> buildColumnFamilyDescriptors(List<String> columnFamilyNames, ColumnFamilyOptions cfOpts) {
        return columnFamilyNames.stream()
                .map(String::getBytes)
                .map(columnFamilyName -> new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY, cfOpts)).collect(Collectors.toList());
    }

    private static DBOptions createDefaultDbOptions() {
        DBOptions options = new DBOptions();
        options.setCreateIfMissing(true);
        options.setCreateMissingColumnFamilies(true);
        options.setKeepLogFileNum(1);
        return options;
    }

    private static ColumnFamilyOptions createDefaultColumnFamilyOptions() {
        ColumnFamilyOptions cfOpts = new ColumnFamilyOptions();
        cfOpts.optimizeUniversalStyleCompaction();
        return cfOpts;
    }

    @Override
    public void close() {
        for (ColumnFamilyHandle columnFamilyHandle : columnFamilyHandleMap.values()) {
            columnFamilyHandle.close();
        }
        db.close();
    }

    public Optional<String> findString(String columnFamilyName, String key) throws RocksDBException {
        ColumnFamilyHandle columnFamilyHandle = columnFamilyHandleMap.get(columnFamilyName);
        byte[] bytes = db.get(columnFamilyHandle, key.getBytes());
        if (Objects.isNull(bytes)) {
            return Optional.empty();
        }
        return Optional.of(new String(bytes));
    }

    public void saveString(String columnFamilyName, String key, String value) throws RocksDBException {
        ColumnFamilyHandle columnFamilyHandle = columnFamilyHandleMap.get(columnFamilyName);
        db.put(columnFamilyHandle,key.getBytes(),value.getBytes());
    }
}
