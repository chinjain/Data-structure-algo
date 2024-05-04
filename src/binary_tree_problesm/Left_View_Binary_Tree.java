package binary_tree_problesm;

import java.util.ArrayList;
import java.util.List;

public class Left_View_Binary_Tree {

	public static void main(String[] args) {
		Tree node = new Tree(1);
		node.left = new Tree(2);
		node.left.left = new Tree(4);
		node.left.right = new Tree(5);
		node.left.right.left = new Tree(6);
		node.right = new Tree(3);
		node.right.right = new Tree(7);

		List<Integer> list = new ArrayList<Integer>();
		leftView(list, node, 0);
		list.forEach(System.out::println);
	}

	private static void leftView(List<Integer> list, Tree node, int lvl) {

		if (node == null) {
			return;
		}

		if (list.size() == lvl) {
			list.add(node.val);
		}

		leftView(list, node.left, lvl + 1);
		leftView(list, node.right, lvl + 1);
	}

}
