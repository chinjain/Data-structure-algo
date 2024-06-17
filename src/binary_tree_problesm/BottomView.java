package binary_tree_problesm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

	/*
	 * Approach to solve this problem is
	 * 
	 * We will maintain one queue of pair<node and its Vertical Index Value> we will
	 * create one map and store the vertical index value and node value if present
	 * update the value other wise add the value into it
	 *
	 * now we will do the BFS of tree using queue and the final map value into the
	 * List<Integer>
	 * 
	 */

	public static void main(String[] args) {
		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.left.left = new Tree(4);
		root.left.right = new Tree(10);
		root.left.left.right = new Tree(5);
		root.left.left.right.right = new Tree(6);
		root.right = new Tree(3);
		root.right.right = new Tree(10);
		root.right.left = new Tree(9);

		List<Integer> viewList = bottomView(root);
		viewList.stream().forEach(System.out::println);
	}

	private static List<Integer> bottomView(Tree root) {
		List<Integer> response = new ArrayList<Integer>();
		Queue<Pair> q = new LinkedList<>();

		Map<Integer, Integer> map = new TreeMap<>();

		q.add(new Pair(root, 0));

		while (!q.isEmpty()) {

			Pair pair = q.poll();
			Tree node = pair.getNode();
			int link = pair.getValue();

			if (node == null) {
				continue;
			}

			map.put(link, node.val);

			if (node.left != null) {
				q.add(new Pair(node.left, link - 1));
			}

			if (node.right != null) {
				q.add(new Pair(node.right, link + 1));
			}

		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			response.add(entry.getValue());	
		}

		return response;
	}

}
