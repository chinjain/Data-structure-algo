package linkedlist_problems;

import java.util.Stack;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head.next.next.next = new Node(4);

		System.out.println("Original Linked List: ");
		printLinkedList(head);

		bruteForceApproach(head);
		OptimalApproach(head);

	}

	private static void OptimalApproach(Node head) {

		Node temp = head;
		Node prev = null;

		while (temp != null) {
			Node front = temp.next;
			temp.next = prev;
			prev = temp;
			temp = front;
		}

		System.out.println("ReverseLinkedList.OptimalApproach()");
		head = prev;
		printLinkedList(head);

	}

	private static void bruteForceApproach(Node head) {
		Node temp = head;

		Stack<Integer> stack = new Stack<Integer>();

		while (temp != null) {
			stack.push(temp.val);
			temp = temp.next;
		}

		temp = head;

		while (temp != null) {
			temp.val = stack.pop();
			temp = temp.next;
		}

		System.out.println("ReverseLinkedList.bruteForceApproach()");
		printLinkedList(head);

	}

	private static void printLinkedList(Node head) {

		Node node = head;

		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}

	}

}
