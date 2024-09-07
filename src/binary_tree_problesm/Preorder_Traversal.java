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

		inorderNode.forEach(System.out::println);

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
