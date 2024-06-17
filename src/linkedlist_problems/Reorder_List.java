package linkedlist_problems;

public class Reorder_List {

	public static void main(String[] args) {

		Node head = new Node(0);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(5);
		head.next.next.next.next.next.next = new Node(6);

		reorder(head);
	}

	private static void reorder(Node head) {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node second = slow.next;
		Node prev = slow.next = null;

		while (second != null) {
			Node temp = second.next;
			second.next = prev;
			prev = second;
			second = temp;
		}

		second = prev;
		Node first = head;

		while (second != null) {
			Node t1 = first.next;
			Node t2 = second.next;

			first.next = second;
			second.next = t1;
			first = t1;
			second = t2;

		}

		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}

	}

}
