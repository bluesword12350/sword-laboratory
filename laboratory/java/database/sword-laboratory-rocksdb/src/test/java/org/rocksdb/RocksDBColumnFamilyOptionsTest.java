package org.rocksdb;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RocksDBColumnFamilyOptionsTest {

    private static RocksDB db;
    private static List<ColumnFamilyHandle> columnFamilyHandleList;

    @BeforeAll
    static void before() throws RocksDBException {
        RocksDB.loadLibrary();
        ColumnFamilyOptions cfOpts = new ColumnFamilyOptions();
        DBOptions options = new DBOptions();
        try(cfOpts;options) {
            cfOpts.optimizeUniversalStyleCompaction();
            final List<ColumnFamilyDescriptor> cfDescriptors = List.of(
                    new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY, cfOpts),
                    new ColumnFamilyDescriptor("columnFamily".getBytes(), cfOpts)
            );
            options.setCreateIfMissing(true);
            options.setCreateMissingColumnFamilies(true);
            options.setKeepLogFileNum(1);
            columnFamilyHandleList = new ArrayList<>();
            db = RocksDB.open(options,"database/rocks", cfDescriptors, columnFamilyHandleList);
        }
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
        ColumnFamilyHandle columnFamilyHandle = columnFamilyHandleList.get(1);
        long l = new Random().nextLong();
        String v = Long.toHexString(l);
        byte[] k = "k1".getBytes();
        db.put(columnFamilyHandle,k,v.getBytes());
        String v2 = new String(db.get(columnFamilyHandle, k));
        System.out.println(String.format("v:%s v2:%s eq:%b",v,v2,v.equals(v2)));
    }

    @Test
    void dropColumnFamily() throws RocksDBException {
        db.dropColumnFamily(columnFamilyHandleList.get(2));
    }

    @AfterAll
    static void after(){
        for (final ColumnFamilyHandle columnFamilyHandle : columnFamilyHandleList) {
            columnFamilyHandle.close();
        }
        db.close();
    }
}
