package binary_tree_problesm;

import java.util.ArrayList;
import java.util.List;

public class Right_View_Binary_Tree {

	public static void main(String[] args) {

		/*
		 * 
		 * Approach we will follow is :
		 * 
		 * Last node of all the level will be my answer
		 * 
		 * 1 2 3 4 5 7 6
		 * 
		 * so here right view of the tree is 1,3,7,6 as we can see that all the node
		 * from the last level is printed
		 * 
		 * 1. we will check all the traversal technique 2. In the wors case if we use
		 * The level order traversal technique then what will happen at last node it
		 * will store all the values in it which is not required.
		 * 
		 * 
		 * 
		 */

		Tree node = new Tree(1);
		node.left = new Tree(2);
		node.left.left = new Tree(4);
		node.left.right = new Tree(5);
		node.left.right.left = new Tree(6);
		node.right = new Tree(3);
		node.right.right = new Tree(7);

		List<Integer> integers = new ArrayList<Integer>();

		rightView(node, integers, 0);
		integers.forEach(System.out::println);
		
		

	}

	private static void rightView(Tree node, List<Integer> integers, int level) {
		if (node == null) {
			return;
		}

		if (integers.size() == level) {
			integers.add(node.val);
		}

		rightView(node.right, integers, level + 1);
		rightView(node.left, integers, level + 1);
	}

}
