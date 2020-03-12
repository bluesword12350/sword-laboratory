package org.mapdb;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DBTest {

    private static DB db;

    @BeforeAll
    static void make(){
        db = DBMaker
                .fileDB("file.db")
                .fileMmapEnable()
                .checksumHeaderBypass()
                .make();
        db.hashSet("setTest");
    }

    @Test
    void getAll(){
        System.out.println(db.getAll().entrySet());
    }

    @AfterAll
    static void close(){
        db.close();
    }
}
