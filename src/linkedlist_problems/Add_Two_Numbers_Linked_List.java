package linkedlist_problems;

public class Add_Two_Numbers_Linked_List {

	public static void main(String[] args) {

		Node l1 = new Node(3);
		l1.next = new Node(4);
		l1.next.next = new Node(2);

		Node l2 = new Node(4);
		l2.next = new Node(6);
		l2.next.next = new Node(5);
		
		getSumOfLinkedList(l1,l2);

	}

	private static void getSumOfLinkedList(Node l1, Node l2) {
		Node dummy = new Node(0);
		Node pointer = dummy;
		int carry = 0;
		
		while(l1 != null || l2 != null || carry == 1) {
			int sum = 0;
			
			if(l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			
			if(l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			
			sum += carry;
			carry = sum/10;
			Node result = new Node(sum % 10);
			pointer.next = result;
			pointer = pointer.next;
			
		}
		
		while(dummy.next != null) {
			System.out.print(dummy.next.val + " ");
			dummy = dummy.next;
		}
		
		
	}

}
