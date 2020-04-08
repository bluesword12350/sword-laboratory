package top.bluesword.java.util;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class LinkedListTest {

	@Test
	void add(){
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(null);
		System.out.println(linkedList);
		
		linkedList.add(1, 3);
		System.out.println(linkedList);
	}

	@Test
	void peek(){
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);

		Integer peek = linkedList.peek();
		System.out.println(peek);
		System.out.println(linkedList.size());
	}

	@Test
	void poll(){
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);

		Integer poll = linkedList.poll();
		System.out.println(poll);
		System.out.println(linkedList.size());
	}

}