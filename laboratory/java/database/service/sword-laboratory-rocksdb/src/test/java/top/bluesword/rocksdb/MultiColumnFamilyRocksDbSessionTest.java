package top.bluesword.rocksdb;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.rocksdb.RocksDBException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiColumnFamilyRocksDbSessionTest {

    private static MultiColumnFamilyRocksDbSession rocksDbSession;

    @BeforeAll
    static void init() throws RocksDBException {
        rocksDbSession = MultiColumnFamilyRocksDbSession.init("database", List.of("c1","c3","c2"));
    }

    @Test
    void saveString() throws RocksDBException {
        String columnFamilyName = "c3";
        String key = "k3";
        String value = "3";
        rocksDbSession.saveString(columnFamilyName,key,value);
        Optional<String> string = rocksDbSession.findString(columnFamilyName, key);
        string.ifPresent(s -> assertEquals(value, s));
    }

    @AfterAll
    static void close() {
        rocksDbSession.close();
    }

}