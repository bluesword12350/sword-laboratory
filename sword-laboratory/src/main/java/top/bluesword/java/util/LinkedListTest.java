package top.bluesword.java.util;

import java.util.LinkedList;

import com.alibaba.fastjson.JSON;

public class LinkedListTest {
	public static void main(String[] args){
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		System.out.println(JSON.toJSONString(linkedList));
		
		linkedList.add(1, 3);
		System.out.println(JSON.toJSONString(linkedList));
	}
}