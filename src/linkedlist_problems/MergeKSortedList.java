package linkedlist_problems;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

	public static void main(String[] args) {

		Node l1 = new Node(1);
		l1.next = new Node(3);
		l1.next.next = new Node(5);

		Node l2 = new Node(10);
		l2.next = new Node(9);
		l2.next.next = new Node(7);

		List<Node> nodes = Arrays.asList(l1, l2);

		mergeKBruteForce(nodes);

	}

	private static void mergeKBruteForce(List<Node> nodes) {

		PriorityQueue<Node> nodeMinHeap = new PriorityQueue<Node>((a, b) -> a.val - b.val);
		
		/*
		 * This loop will insert all the first node of the K linked list present afte that we 
		 * will put the value into the queue and form the sorted single list 
		 * 
		 */
		for (Node n : nodes) {
			if (n != null) {
				nodeMinHeap.add(n);
			}
		}

		Node dummy = new Node(0);
		Node current = dummy;
		Node iterate = dummy;

		while (!nodeMinHeap.isEmpty()) {
			Node minNode = nodeMinHeap.poll();

			current.next = minNode;
			current = current.next;

			if (minNode.next != null) {
				nodeMinHeap.add(minNode.next);
			}
		}

		System.out.println("MergeKSortedList.mergeKBruteForce()");
		while (iterate != null) {
			System.out.print(iterate.val + "->");
			iterate = iterate.next;
		}

	}

}
