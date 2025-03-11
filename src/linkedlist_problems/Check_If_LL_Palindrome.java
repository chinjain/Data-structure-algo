package linkedlist_problems;

import java.util.Stack;

public class Check_If_LL_Palindrome {

	public static void main(String[] args) {

		/*
		 *
		 * First appraoch is using stack push the linked list into the stack and
		 * traverse the LL and check the node if both of the values are eqaul or not and
		 * pop it ()
		 *
		 * if Not equal break not a Palindrome
		 *
		 */

		Node head = new Node(1);
		head.next = new Node(5);
		head.next.next = new Node(2);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(1);


		bruteforce(head);
		optimalApproach(head);

	}

	public static void bruteforce(Node head){

		Long start = System.currentTimeMillis();

		Stack<Integer> st = new Stack<>();
		Node temp = head;

		while (temp != null){
			st.push(temp.val);

			temp = temp.next;
		}
		
		temp = head;
		
		while (temp != null){
			if(st.peek() != temp.val){
				System.out.println("not a plindrome");
				break;
			}

			st.pop();
			temp = temp.next;
		}

		Long end = System.currentTimeMillis();

		System.out.println("[Brute Force] : Palindrome With time : " + (end-start));




	}

	/*

		1.Here we will follow the Recursion appraoch
		2. First find the mid element the from that reverse the list
		3. then compare with head and mid list

	 */

	public static void optimalApproach(Node head){

		Long start = System.currentTimeMillis();

		Node temp = head;
		Node fast = head;
		Node slow = head;

		while (fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		Node reverseHead = reverseLinkedList(slow.next, null);

		while(reverseHead != null){
			if(temp.val != reverseHead.val){
				System.out.println("[Optimal ] Not palindrome");
			}

			reverseHead = reverseHead.next;
			temp = temp.next;
		}

		Long end = System.currentTimeMillis();

		System.out.println("{Optimal} : Palindrome With time :" + (end-start));


	}
//null<-1<-2 3-4-5-6-7
	private static Node reverseLinkedList(Node head, Node prev){

		if(head == null){
			return prev;
		}

		Node temp = head.next;
		head.next = prev;

		return reverseLinkedList(temp,head);
	}

}
