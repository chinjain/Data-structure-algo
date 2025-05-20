package linkedlist_problems;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		Node l1 = new Node(3);
		l1.next = new Node(7);
		l1.next.next = new Node(10);

		Node l2 = new Node(1);
		l2.next = new Node(2);
		l2.next.next = new Node(5);
		l2.next.next.next = new Node(8);
		l2.next.next.next.next = new Node(10);

		 bruteForcapproach(l1, l2);
		withoutUsingExtraSpaceOptimal(l1, l2);

	}

	private static void withoutUsingExtraSpaceOptimal(Node l1, Node l2) {

		if (l1.val > l2.val) {
			Node temp = l1;
			l1 = l2;
			l2 = temp;
		}

		while (l1 != null && l2 != null) {
			Node tmp = null;
			while (l1 != null && l1.val <= l2.val) {
				tmp = l1;
				l1 = l1.next;
			}

			tmp.next = l2;
			Node temporary = l1;
			l1 = l2;
			l2 = temporary;
		}

	}

	private static void bruteForcapproach(Node l1, Node l2) {

		Node t1 = l1;
		Node t2 = l2;
		Node dummy = new Node(0);
		Node head = dummy;

		while (t1 != null && t2 != null) {

			if (t1.val < t2.val) {
				head.next = t1;
				t1 = t1.next;
			} else {
				head.next = t2;
				t2 = t2.next;
			}

			head = head.next;

		}

		if (t1 != null) {
			head.next = t1;
		}

		if (t2 != null) {
			head.next = t2;
		}

		while (dummy != null) {
			System.out.print(dummy.next.val + "->");
			dummy = dummy.next;
		}

	}

}
