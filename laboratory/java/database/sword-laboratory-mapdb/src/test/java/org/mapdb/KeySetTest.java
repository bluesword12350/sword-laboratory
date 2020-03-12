package org.mapdb;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class KeySetTest {

    private static DB db;
    private static HTreeMap.KeySet<String> set;

    @BeforeAll
    static void make(){
        db = DBMaker
                .fileDB("file.db")
                .fileMmapEnable()
                .checksumHeaderBypass()
                .make();
        set = db.hashSet("set-llf", Serializer.STRING).createOrOpen();
    }

    @Test
    void add(){
        System.out.println(set.add("something"));
    }

    @Test
    void contains(){
        System.out.println(set.contains("something"));
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
