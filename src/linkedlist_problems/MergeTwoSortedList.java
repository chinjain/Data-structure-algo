package linkedlist_problems;

public class MergeTwoSortedList {


	/*
	 BRUTE FORCE :

	 Put all the element in the array List & Sort them then make the linked list again :)
	 */

	public static void main(String[] args) {
		Node l1 = new Node(3);
		l1.next = new Node(7);
		l1.next.next = new Node(10);

		Node l2 = new Node(1);
		l2.next = new Node(2);
		l2.next.next = new Node(5);
		l2.next.next.next = new Node(8);
		l2.next.next.next.next = new Node(10);

		withoutUsingExtraSpaceOptimal(l1, l2);



	}

	private static void withoutUsingExtraSpaceOptimal(Node l1, Node l2) {
		Node dummy = new Node(0);
		Node cur = dummy;

		while (l1 != null && l2 != null){
			if(l1.val <= l2.val){
				cur.next = l1;
				l1 = l1.next;
			}else{
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		if(l1 != null){
			cur.next = l1;
		}else{
			cur.next = l2;
		}

		while (dummy.next != null){
			System.out.print(dummy.next.val + "->");
			dummy = dummy.next;
		}

	}

}
