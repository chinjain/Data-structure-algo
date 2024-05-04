package linkedlist_problems;

import java.util.HashSet;

public class Interserction_Of_Two_Noder {

	public static void main(String[] args) {

		Node n1 = new Node(1);
		n1.next = new Node(2);
		n1.next.next = new Node(3);
		n1.next.next.next = new Node(4);
		n1.next.next.next.next = new Node(5);
		n1.next.next.next.next.next = new Node(6);
		n1.next.next.next.next.next.next = new Node(7);

		Node n2 = new Node(10);
		n2.next = new Node(9);
		n2.next.next = new Node(8);
		n2.next.next.next = n1.next.next.next;

		usingHash(n1, n2);
		twoPointer(n1, n2);
	}

	private static void twoPointer(Node n1, Node n2) {
		Node p1 = n1;
		Node p2 = n2;

		System.out.println("Interserction_Of_Two_Noder.twoPointer()");
		if (p1 == null || p2 == null) {
			return;
		}

		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;

			if (p1 == p2) {
				System.out.println(p1.val);
				break;
			}

			if (p1 == null) {
				p1 = n2;
			}

			if (p2 == null) {
				p2 = n1;
			}
		}

	}

	private static void usingHash(Node n1, Node n2) {
		HashSet<Node> nodes = new HashSet<Node>();

		while (n1 != null) {
			nodes.add(n1);
			n1 = n1.next;
		}

		while (n2 != null) {
			if (nodes.contains(n2)) {
				System.out.println(n2.val);
				break;
			}

			nodes.add(n2);
			n2 = n2.next;
		}

	}

}
