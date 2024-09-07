package binary_tree_problesm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.stream.Collectors;

public class TopView {

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

		topView(root);

	}

	private static void topView(Tree root) {

		Queue<Pair> queue = new LinkedList<Pair>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		queue.add(new Pair(root, 0));

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			Tree node = pair.getNode();
			int link = pair.getValue();

			if (!map.containsKey(link)) {
				map.put(link, node.val);
			}

			if (node.left != null) {
				queue.add(new Pair(node.left, link - 1));
			}

			if (node.right != null) {
				queue.add(new Pair(node.right, link + 1));
			}
		}

		List<Integer> ans = new ArrayList<Integer>(map.values());
		ans.forEach(System.out::println);

	}

}
