package top.bluesword.rocksdb;

import org.rocksdb.RocksDBException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李林峰
 */
public class MultiColumnFamilyRocksDbSessionManager implements AutoCloseable {

    private final Map<String, MultiColumnFamilyRocksDbSession> sessionMap = new HashMap<>();
    private final String basePath;

    public MultiColumnFamilyRocksDbSessionManager(String basePath) {
        this.basePath = basePath;
    }

    public MultiColumnFamilyRocksDbSession buildAndPut(String tableName, List<String> columnFamilyNames) throws RocksDBException {
        remove(tableName);
        MultiColumnFamilyRocksDbSession session = MultiColumnFamilyRocksDbSession.init(basePath + "/" + tableName, columnFamilyNames);
        sessionMap.put(tableName,session);
        return session;
    }

    private void remove(String tableName) {
        if (!sessionMap.containsKey(tableName)) {
            return;
        }
        MultiColumnFamilyRocksDbSession rocksDbSession = sessionMap.get(tableName);
        try(rocksDbSession) {
            sessionMap.remove(tableName);
        }
    }

    public MultiColumnFamilyRocksDbSession get(String tableName){
        return sessionMap.get(tableName);
    }

    @Override
    public void close() {
        for (MultiColumnFamilyRocksDbSession session : sessionMap.values()) {
            session.close();
        }
    }
}
