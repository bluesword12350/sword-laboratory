package top.bluesword.rocksdb;

import org.rocksdb.RocksDBException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李林峰
 */
public class DefaultRocksDbSessionManager implements AutoCloseable {

    private final Map<String, DefaultRocksDbSession> sessionMap = new HashMap<>();
    private final String basePath;

    public DefaultRocksDbSessionManager(String basePath) {
        this.basePath = basePath;
    }

    public DefaultRocksDbSession buildAndPut(String tableName) throws RocksDBException {
        remove(tableName);
        DefaultRocksDbSession session = DefaultRocksDbSession.init(basePath + "/" + tableName);
        sessionMap.put(tableName,session);
        return session;
    }

    private void remove(String tableName) {
        if (!sessionMap.containsKey(tableName)) {
            return;
        }
        DefaultRocksDbSession rocksDbSession = sessionMap.get(tableName);
        try(rocksDbSession) {
            sessionMap.remove(tableName);
        }
    }

    public DefaultRocksDbSession get(String tableName){
        return sessionMap.get(tableName);
    }

    @Override
    public void close() {
        for (DefaultRocksDbSession session : sessionMap.values()) {
            session.close();
        }
    }
}
