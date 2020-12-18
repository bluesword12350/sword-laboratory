package top.bluesword.rocksdb;

import org.rocksdb.RocksDBException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李林峰
 */
public class RocksDbSessionManager implements AutoCloseable {

    private final Map<String, RocksDbSession> sessionMap = new HashMap<>();
    private final String basePath;

    public RocksDbSessionManager(String basePath) {
        this.basePath = basePath;
    }

    public RocksDbSession buildAndPut(String tableName, List<String> columnFamilyNames) throws RocksDBException {
        remove(tableName);
        RocksDbSession session = RocksDbSession.init(basePath + "/" + tableName, columnFamilyNames);
        sessionMap.put(tableName,session);
        return session;
    }

    private void remove(String tableName) {
        if (!sessionMap.containsKey(tableName)) {
            return;
        }
        RocksDbSession rocksDbSession = sessionMap.get(tableName);
        try(rocksDbSession) {
            sessionMap.remove(tableName);
        }
    }

    public RocksDbSession get(String tableName){
        return sessionMap.get(tableName);
    }

    @Override
    public void close() {
        for (RocksDbSession session : sessionMap.values()) {
            session.close();
        }
    }
}
