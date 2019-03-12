package top.bluesword.util.base;

import org.junit.jupiter.api.Test;

import top.bluesword.util.sequence.Snowflake;

import java.util.HashMap;
import java.util.Map;

class KeyValueQueueTest {

    private static KeyValueQueue keyValueQueue = new KeyValueQueue("test_queue");

    @Test
    void mainTest(){
        add();
        poll();
    }

    void add() {
        keyValueQueue.add("123".getBytes());
        keyValueQueue.add("456".getBytes());
    }

    void poll() {
        byte[] poll = keyValueQueue.poll();
        while (poll!=null){
            System.out.println(new String(poll));
            poll = keyValueQueue.poll();
        }
    }
}

class KeyValueQueue{

    private Map<String,byte[]> map;
    private String head;
    private String last;
    private Snowflake snowflake;
    private String queueName;

    KeyValueQueue(String queueName){
        snowflake = new Snowflake();
        map = new HashMap<>();
        this.queueName = queueName;
    }

    public void add(byte[] bytes) {
        String keyStr = queueName+":"+snowflake.nextId().toString();
        map.put(keyStr,bytes);
        if (head==null) head = keyStr;
        else map.put(last + ":next", keyStr.getBytes());
        last = keyStr;
    }

    byte[] poll() {
        if (head==null) return null;
        byte[] bytes = map.get(head);
        map.remove(head);
        String headNextKey = head + ":next";
        byte[] next = map.get(headNextKey);
        if (next==null) head = null;
        else head = new String(next);
        map.remove(headNextKey);
        return bytes;
    }
}