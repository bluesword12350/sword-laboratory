package top.bluesword.java.util;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue 
		= new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		priorityQueue.add(1);
		priorityQueue.add(2);
		System.out.println(priorityQueue.peek());
		priorityQueue.add(2);
		System.out.println(priorityQueue.size());
	}
}
