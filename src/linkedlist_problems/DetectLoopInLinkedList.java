package linkedlist_problems;

import java.util.HashMap;
import java.util.Map;

public class DetectLoopInLinkedList {

	public static void main(String[] args) {

		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		// Create a loop
		fifth.next = third;

		bruteForce(head);
		optimalApproach(head);

	}

	private static void optimalApproach(Node head) {

		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next != slow) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		System.out.println("DetectLoopInLinkedList.optimalApproach()");
		System.out.println(slow.val);

	}

	private static void bruteForce(Node head) {

		Node temp = head;
		Map<Node, Integer> nodes = new HashMap<Node, Integer>();

		while (temp != null) {
			if (nodes.containsKey(temp)) {
				System.out.println("Cycle Is present in LL " + nodes.get(temp));
				break;
			}

			nodes.put(temp, temp.val);
			temp = temp.next;
		}

	}

}
