package top.bluesword.rocksdb;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

import java.util.Objects;
import java.util.Optional;

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
        RocksDB db;
        try(options) {
            options.setCreateIfMissing(true);
            db = RocksDB.open(options, path);
        }
        return new DefaultRocksDbSession(db);
    }

    public Optional<String> findString(String key) throws RocksDBException {
        byte[] bytes = db.get(key.getBytes());
        if (Objects.isNull(bytes)) {
            return Optional.empty();
        }
        return Optional.of(new String(bytes));
    }

    public void saveString(String key, String value) throws RocksDBException {
        db.put(key.getBytes(),value.getBytes());
    }

    @Override
    public void close() {
        db.close();
    }

}
