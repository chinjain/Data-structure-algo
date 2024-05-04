package linkedlist_problems;

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		Node node = findMiddleValue(head);

		if (node != null) {
			System.out.println(" -> " + node.val);
		} else {
			System.out.println("Not Found");
		}
	}

	private static Node findMiddleValue(Node head) {

		if (head == null) {
			return null;
		}

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;	
	}

}
