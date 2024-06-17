package binary_tree_problesm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level_order_traversal {

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

		levelTraversal(root);
	}

	private static void levelTraversal(Tree root) {

		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		while (queue.size() > 0) {
			int count = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < count; i++) {

				Tree node = queue.remove();
				list.add(node.val);

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}

			}
			res.add(list);

		}

		res.stream().forEach(System.out::println);

	}

}
