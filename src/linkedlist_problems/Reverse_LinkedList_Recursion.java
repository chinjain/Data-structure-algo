package linkedlist_problems;

public class Reverse_LinkedList_Recursion {

	public static void main(String[] args) {

		Node head = new Node(0);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);

		Node newHead = reverse(head, null);

		while (newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}

	}

	private static Node reverse(Node node, Node prev) {
		if (node == null)
			return prev;

		Node temp = node.next;
		node.next = prev;

		return reverse(temp, node);
	}

	// 1 -> 2 -> 3 -> 5 -> 4 -> null ;

//	private static Node reverse(Node head) {
//
//		if (head == null || head.next == null) {
//			return head;
//		}
//
//		Node newHead = reverse(head.next);
//		head.next.next = head;
//		head.next = null;
//
//		return newHead;
//
//	}

}
