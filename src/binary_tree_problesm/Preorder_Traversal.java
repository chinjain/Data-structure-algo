package binary_tree_problesm;

import java.util.ArrayList;
import java.util.Stack;

public class Preorder_Traversal {

	public static void main(final String[] args) {

		final Tree tree = new Tree(1);
		tree.left = new Tree(2);
		tree.right = new Tree(3);
		tree.left.left = new Tree(4);
		tree.left.right = new Tree(5);
		tree.right.left = new Tree(6);

		final ArrayList<Integer> inorderNode = new ArrayList<Integer>();

		inorderTraversal(tree, inorderNode);
		final ArrayList<Integer> iterativeOrder = inorderIterativeSolution(tree);

		inorderNode.forEach(System.out::println);

	}

	private static ArrayList<Integer> inorderIterativeSolution(Tree tree) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<Tree> stack = new Stack<Tree>();
		while (true) {

			if (tree != null) {
				stack.push(tree);
				tree = tree.left;
			} else {
				if (stack.isEmpty())
					break;
				tree = stack.peek();
			}
		}

		return res;

	}

	private static void inorderTraversal(final Tree node, final ArrayList<Integer> arrayList) {

		if (node == null) {
			return;
		}

		inorderTraversal(node.left, arrayList);
		arrayList.add(node.val);
		inorderTraversal(node.right, arrayList);

	}

}
