package binary_tree_problesm;

public class Size_Sum_Max_Height_Binary_tree {

	public static void main(String[] args) {

		Tree root = new Tree(50);
		root.left = new Tree(25);
		root.right = new Tree(75);
		root.left.left = new Tree(12);
		root.left.right = new Tree(37);
		root.left.right.left = new Tree(30);
		root.right.left = new Tree(62);
		root.right.right = new Tree(87);
		root.right.left.right = new Tree(70);

		System.out.println("Size of Tree is :" + size(root));
		System.out.println("sum of Nodes is " + sum(root));
		System.out.println("Max Node from the tree is :" + max(root));
		System.out.println(height(root));

	}

	private static int height(Tree root) {

		// -1 for edges & 0 for nodes

		/*
		 * if we have one node then we ls return -1 and rs return -1 and then max of
		 * both is -1 + 1 which is 0
		 * 
		 * so the height of Tree in terms of edges is 0
		 */

		if (root == null) {
			return -1;
		}

		int l_height = height(root.left);
		int r_height = height(root.right);
		int total = Math.max(l_height, r_height) + 1;

		return total;
	}

	private static int max(Tree root) {

		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int ls = max(root.left);
		int rs = max(root.right);
		int tm = Math.max(Math.max(ls, rs), root.val);

		return tm;

	}

	private static int sum(Tree root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return 0;
		}

		int l_sum = sum(root.left);
		int r_sum = sum(root.right);
		int t_sum = l_sum + r_sum + root.val;

		return t_sum;

	}

	private static int size(Tree root) {
		/*
		 * It will give me the total node from the Left Side + right Side Node + 1;
		 */

		if (root == null) {
			return 0;
		}

		int ls = size(root.left);
		int rs = size(root.right);
		int ts = ls + rs + 1;

		return ts;

	}

}
