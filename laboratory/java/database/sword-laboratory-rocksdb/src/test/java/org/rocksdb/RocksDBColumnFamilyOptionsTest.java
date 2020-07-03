package org.rocksdb;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RocksDBColumnFamilyOptionsTest {

    private static DBOptions options;
    private static RocksDB db;
    private static ColumnFamilyOptions cfOpts;
    private static List<ColumnFamilyHandle> columnFamilyHandleList;

    @BeforeAll
    static void before() throws RocksDBException {
        cfOpts = new ColumnFamilyOptions();
        cfOpts.optimizeUniversalStyleCompaction();
        final List<ColumnFamilyDescriptor> cfDescriptors = Arrays.asList(
                new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY, cfOpts),
                new ColumnFamilyDescriptor("columnFamily".getBytes(), cfOpts)
        );
        columnFamilyHandleList = new ArrayList<>();
        RocksDB.loadLibrary();
        options = new DBOptions();
        options.setCreateIfMissing(true);
        options.setCreateMissingColumnFamilies(true);
        options.setKeepLogFileNum(1);
        db = RocksDB.open(options,"database/rocks", cfDescriptors, columnFamilyHandleList);
    }

    @Test
    void iteratorTest() throws RocksDBException {
        for (int i = 0; i < columnFamilyHandleList.size(); i++) {
            ColumnFamilyHandle columnFamilyHandle = columnFamilyHandleList.get(i);
            System.out.println(i+"-name:"+new String(columnFamilyHandle.getName()));
            try (RocksIterator iterator = db.newIterator(columnFamilyHandle)) {
                for (iterator.seekToFirst(); iterator.isValid(); iterator.next()) {
                    System.out.println(new String(iterator.key()));
                }
            }
        }
    }

    @Test
    void putTest() throws RocksDBException {
        db.put(columnFamilyHandleList.get(1),"key1".getBytes(),"1".getBytes());
    }

    @Test
    void dropColumnFamily() throws RocksDBException {
        db.dropColumnFamily(columnFamilyHandleList.get(2));
    }

    @Test
    void getTest() throws RocksDBException {
        System.out.println(new String(db.get(columnFamilyHandleList.get(0),"key1".getBytes())));
    }

    @AfterAll
    static void after(){
        for (final ColumnFamilyHandle columnFamilyHandle : columnFamilyHandleList) {
            columnFamilyHandle.close();
        }
        db.close();
        options.close();
        cfOpts.close();
    }
}
