package org.mapdb;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HTreeMapTest {

    private static DB db;
    private static HTreeMap<String, String> map;

    @BeforeAll
    static void make(){
        db = DBMaker
                .fileDB("file.db")
                .fileMmapEnable()
                .checksumHeaderBypass()
                .make();
        map = db.hashMap("map", Serializer.STRING, Serializer.STRING)
                .createOrOpen();
        HTreeMap.KeySet<String> set = db.hashSet("set-1", Serializer.STRING).createOrOpen();
    }

    @Test
    void put(){
        System.out.println(map.put("something", "5"));
    }

    @Test
    void get(){
        System.out.println(map.get("something"));
    }

    @Test
    void getAll(){
        System.out.println(db.getAll());
    }

    @AfterAll
    static void close(){
        db.close();
    }
}
