package binary_tree_problesm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static binary_tree_problesm.InvertTree.print;

public class Construct_BT_Preorder_Inorder {

	public static void main(String[] args) {
		List<Integer> in = Arrays.asList(9, 3, 15, 20, 7);
		List<Integer> pre = Arrays.asList(3, 9, 20, 15, 7);

		Tree node = buildTree(in, pre);

		print(node);
	}

	static Tree buildTree(List<Integer> in, List<Integer> pre){

		int n = in.size();
		int[] p_index = new int[1];
		p_index[0] = 0;


		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++){
			map.putIfAbsent(in.get(i),i);
		}
		return buildTreeUtil(in,pre,0, n - 1, p_index, map);
	}

	private static Tree buildTreeUtil(List<Integer> in, List<Integer> pre, int start, int end, int[] pIndex, Map<Integer, Integer> map) {

		if(start > end)
			return null;

		Tree node = new Tree(pre.get(pIndex[0]));
		pIndex[0]++;

		if(start == end)
			return node;

		int inIndex = map.get(node.val);

		node.left = buildTreeUtil(in,pre,start,inIndex -1, pIndex, map);
		node.right = buildTreeUtil(in, pre, inIndex + 1, end, pIndex, map);

		return  node;
	}

}
