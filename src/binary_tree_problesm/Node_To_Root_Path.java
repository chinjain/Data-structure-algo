package binary_tree_problesm;

import java.util.ArrayList;
import java.util.List;

public class Node_To_Root_Path {

	/*
	 * 
	 * in this we have the expectation that if we given the node then we need to
	 * find the path
	 * 
	 * use case: It is assured that the node V is present and a path always exists.
	 * 
	 * No two nodes in the tree have the same data value.
	 * 
	 * Here the solution says that: -> if the root is null we will return false
	 * 
	 * else we will add the value of the root to the list & if the data value
	 * equivalent to the given node then we will return true we get it
	 * 
	 * else we will check the left || right of the tree whenever we find the val we
	 * will return true for sure...
	 * 
	 * 
	 * 
	 */

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

		List<Integer> node = new ArrayList<Integer>();
		getPath(root, 30, node);

		node.stream().forEach(System.out::println);

	}

	private static boolean getPath(Tree root, int data, List<Integer> node) {

		if (root == null) {
			return false;
		}

		node.add(root.val);

		if (root.val == data) {
			return true;
		}

		if (getPath(root.left, data, node) || getPath(root.right, data, node)) {
			return true;
		}

		node.remove(node.size() - 1);
		return false;
	}

}
