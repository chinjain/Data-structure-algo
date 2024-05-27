package linkedlist_problems;

public class Remove_N_Node {

	/*
	 * 
	 * Remove the nth node from the end of the list
	 * 
	 * we will use 2 pointer approach to solve this issue
	 * 
	 * first we will move to fast pointer till nth position from the start
	 * 
	 * then we will start slow & fast till fast.next != null then we will make
	 * slow.next = slow.next.mext;
	 * 
	 * 
	 */

	public static void main(String[] args) {

		Node n1 = new Node(10);
		n1.next = new Node(20);
		n1.next.next = new Node(30);
		n1.next.next.next = new Node(40);
		n1.next.next.next.next = new Node(50);

		removeNNode(n1, 3);

	}

	private static void removeNNode(Node n1, int i) {

		Node temp = new Node(0);
		temp.next = n1;
		Node slow = temp;
		Node fast = temp;

		while (i > 0) {
			fast = fast.next;
			i--;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		while (temp != null) {
			System.out.println(temp.next.val + "->");
			temp = temp.next;
		}

	}

}
