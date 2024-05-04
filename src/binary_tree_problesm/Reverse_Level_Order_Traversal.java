package binary_tree_problesm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_Level_Order_Traversal {

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

		printLevelOrderTraversal(root);

	}

	private static void printLevelOrderTraversal(Tree root) {

		Queue<Tree> queue = new LinkedList<Tree>();
		Stack<Tree> stack = new Stack<Tree>();

		queue.offer(root);
		while (!queue.isEmpty()) {
			root = queue.remove();

			stack.push(root);

			if (root.left != null) {
				queue.add(root.left);
			}
			if (root.right != null) {
				queue.add(root.right);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().val + "->");
		}
	}

}