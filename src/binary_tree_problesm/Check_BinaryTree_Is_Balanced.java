package binary_tree_problesm;

public class Check_BinaryTree_Is_Balanced {

	/*
	 * 
	 * The h(left) - h(right) <= 1 so the tree is balanced
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

		System.out.println(height(root) != -1);
	}

	private static int height(Tree root) {

		if (root == null) {
			return 0;
		}

		int lh = height(root.left);
		if (lh == -1) {
			return -1;
		}

		int rh = height(root.right);
		if (rh == -1) {
			return -1;
		}

		if (Math.abs(lh - rh) > 1) {
			return -1;
		}

		return Math.max(lh, rh) + 1;
	}
}
