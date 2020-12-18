package org.mapdb;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mapdb.btree.Tuple;
import org.mapdb.btree.TupleSerializer;

import java.util.NavigableSet;

class NavigableSetTest {

    private static DB db;
    private static NavigableSet<Tuple> set;

    @BeforeAll
    static void make(){
        db = DBMaker
                .fileDB("file.db")
                .fileMmapEnable()
                .checksumHeaderBypass()
                .make();
        set = db.treeSet("persons", new TupleSerializer())
                .createOrOpen();
    }

    @Test
    void put(){
        set.add(new Tuple("Smith","John",45) );
        set.add(new Tuple("Smith","Peter", 37));
        set.add(new Tuple("Doe","John",70));
    }

    @Test
    void descendingSet(){
        NavigableSet<Tuple> tuples = set.descendingSet();
        System.out.println(tuples);
    }

    @Test
    void headSet(){
        NavigableSet<Tuple> tuples = set.headSet(new Tuple(null, null, 45), false);
        System.out.println(tuples);
    }

    @AfterAll
    static void close(){
        db.close();
    }

}
