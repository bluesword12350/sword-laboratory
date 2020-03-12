package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class LinkedListTest {

	@Test
	void add(){
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		System.out.println(linkedList);
		
		linkedList.add(1, 3);
		System.out.println(linkedList);
	}
}