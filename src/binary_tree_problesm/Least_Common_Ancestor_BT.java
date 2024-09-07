package binary_tree_problesm;

public class Least_Common_Ancestor_BT {

	public static void main(String[] args) {

		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(4);
		root.left.right = new Tree(5);
		root.left.right.left = new Tree(6);
		root.left.right.right = new Tree(7);
		root.right.left = new Tree(8);
		root.right.right = new Tree(9);

		Tree node = lca(root, 9, 2);

		System.out.println(node.val);
	}

	private static Tree lca(Tree root, int i, int j) {

		if (root == null || root.val == i || root.val == j) {
			return root;
		}

		Tree l_node = lca(root.left, i, j);
		Tree r_nTree = lca(root.right, i, j);

		if (l_node != null && r_nTree != null) {
			return root;
		}
		return l_node != null ? l_node : r_nTree;
	}

}
