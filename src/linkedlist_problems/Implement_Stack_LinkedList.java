package linkedlist_problems;

public class Implement_Stack_LinkedList {

	public static void main(String[] args) {
		StackLinkedList st = new StackLinkedList();

		st.push(5);
		st.push(6);
		st.push(2);
		st.push(1);

		st.printStack();
		System.out.println(st.pop());
		st.printStack();

	}

}

class StackLinkedList {

	private Node top;

	public StackLinkedList() {
		this.top = null;

	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		System.out.println(data + " pushed to the stack");
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty. Cannot pop.");
			return -1;
		}

		int poppedValue = top.val;
		top = top.next;

		return poppedValue;
	}

	public void printStack() {
		Node current = top;
		System.out.print("Stack: ");
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

}