package linkedlist_problems;

import java.util.ArrayList;
import java.util.List;

public class Reorder_List {

	public static void main(String[] args) {

		Node head = new Node(0);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(5);
		head.next.next.next.next.next.next = new Node(6);

//		brute(head);
		reorder(head);

	}

	static void brute(Node head){
		List<Node> nodes = new ArrayList<>();
		Node curr = head;

		while (curr != null){
			nodes.add(curr);
			curr = curr.next;
		}

		int left = 0;
		int right = nodes.size() - 1;


		while (left < right){
			nodes.get(left).next = nodes.get(right);
			left++;

			if(left == right)
				break;

			nodes.get(right).next = nodes.get(left);
			right--;
		}

		nodes.get(left).next = null;

	}

	private static void reorder(Node head) {
		if(head == null || head.next == null)
			return;

		Node slow = head;
		Node fast = head;

		//mid
		while (fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		Node curr = slow.next;
		slow.next = null;
		Node prev = null;

		// reverse the second half
		while (curr != null){
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		Node first = head;
		Node second = prev;

		while (second != null){
			Node t1 = first.next;
			Node t2 = second.next;

			first.next = second;
			second.next = t1;

			first = t1;
			second = t2;
		}

		while (head != null){
			System.out.print(head.val + "->");
			head = head.next;
		}

	}
}
