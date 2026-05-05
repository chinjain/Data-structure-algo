package binary_tree_problesm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Vertical_Order_Traversal {

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

		List<List<Integer>> res = new ArrayList<>();
		Map<Integer,List<Integer>> map = new HashMap<>();
		Queue<Pair> queue = new LinkedList<>();

		queue.offer(new Pair(root, 0));
		int minCol = Integer.MAX_VALUE;
		int maxCol = Integer.MIN_VALUE;

		while (!queue.isEmpty()){
			Pair curr = queue.poll();
			Tree node = curr.getNode();
			int col = curr.getValue();

			map.putIfAbsent(col,new ArrayList<>());
			map.get(col).add(node.val);

			minCol = Math.min(minCol,col);
			maxCol = Math.max(maxCol, col);

			if(node.left != null)
				queue.add(new Pair(node.left, col - 1));

			if(node.right != null)
				queue.add(new Pair(node.right,col + 1));

		}

		for(int i = minCol; i < maxCol; i++){
			res.add(map.get(i));
		}

		res.forEach(System.out::println);

	}

}
