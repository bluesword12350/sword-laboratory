package top.bluesword.rocksdb;

import org.rocksdb.ColumnFamilyHandle;
import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李林峰
 */
public class DefaultRocksDbSession implements AutoCloseable {

    private final RocksDB db;

    static {
        RocksDB.loadLibrary();
    }

    public DefaultRocksDbSession(RocksDB db) {
        this.db = db;
    }

    public static DefaultRocksDbSession init(String path) throws RocksDBException {
        final Options options = new Options();
        List<ColumnFamilyHandle> columnFamilyHandleList = new ArrayList<>();
        RocksDB db;
        try(options) {
            options.setCreateIfMissing(true);
            db = RocksDB.open(options, path);
        }
        return new DefaultRocksDbSession(db);
    }

    @Override
    public void close() {
        db.close();
    }

}
