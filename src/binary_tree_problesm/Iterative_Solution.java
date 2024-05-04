package binary_tree_problesm;

import java.util.Stack;

public class Iterative_Solution {

	public static void main(String[] args) {
		Tree root = new Tree(50);
		root.left = new Tree(25);
		root.right = new Tree(75);
		root.left.left = new Tree(12);
		root.left.right = new Tree(37);
		root.left.right.left = new Tree(30);
		root.left.right.right = new Tree(40);
		root.left.right.left = new Tree(30);
		root.right.left = new Tree(62);
		root.right.right = new Tree(87);
		root.right.left.right = new Tree(70);
		root.right.left.left = new Tree(60);

		preOrder(root);
		postOder(root);
		inorder(root);

	}

	private static void inorder(Tree root) {

		/*
		 * 
		 * Iterative technique to solve the question
		 * 
		 * left root right
		 * 
		 * Steps we need to follow as
		 * 
		 */

		System.out.println("Iterative_Solution.inorder()");
		Stack<Tree> st = new Stack<Tree>();
		while (true) {
			if (root != null) {
				st.push(root);
				root = root.left;
			} else {
				if (st.isEmpty())
					break;
				root = st.peek();
				System.out.print(root.val + " inorder");
				st.pop();
				root = root.right;
			}
		}

	}

	private static void postOder(Tree root) {

		System.out.println("Iterative_Solution.postOder()");

		Stack<Tree> node1 = new Stack<Tree>();
		Stack<Tree> node2 = new Stack<Tree>();

		node1.add(root);

		while (!node1.isEmpty()) {
			Tree node = node1.pop();

			node2.push(node);

			if (node.left != null) {
				node1.push(node.left);
			}
			if (node.right != null) {
				node1.push(node.right);
			}

		}

		while (!node2.isEmpty()) {

			Tree node = node2.pop();

			System.out.print(node.val + " ");
		}

	}

	private static void preOrder(Tree root) {
		System.out.println("Iterative_Solution.preOrder()");
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(root);

		while (!stack.isEmpty()) {

			Tree node = stack.pop();

			System.out.print(node.val + " ");
			if (node.right != null) {
				stack.push(node.right);
			}

			if (node.left != null) {
				stack.add(node.left);
			}

		}

	}

}
