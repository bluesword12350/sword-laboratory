package org.rocksdb;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 李林峰
 */
class RocksDBTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static Options options;
    private static RocksDB db;

    @BeforeAll
    static void before() throws RocksDBException {
        RocksDB.loadLibrary();
        options = new Options();
        options.setCreateIfMissing(true);
        db = RocksDB.open(options, "database/rocks");
    }

    @Test
    void iteratorTest() {
        try(RocksIterator iterator = db.newIterator()) {
            for (iterator.seekToFirst(); iterator.isValid(); iterator.next()) {
                String s = new String(iterator.key());
                log.info(s);
            }
        }
    }

    @Test
    void putTest() throws RocksDBException {
        db.put("key1".getBytes(),"123".getBytes());
    }

    @Test
    void getTest() throws RocksDBException {
        String k1v = new String(db.get("key1".getBytes()));
        log.info(k1v);
    }

    @AfterAll
    static void after(){
        db.close();
        options.close();
    }
}
