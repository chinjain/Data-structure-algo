package binary_tree_problesm;

public class Traversal_Of_Binary_Tree {

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

		preorderRecursive(root);
		postorderRecursive(root);
		inorderRecursive(root);

	}

	private static void inorderRecursive(Tree root) {

		if (root == null) {
			return;
		}

		inorderRecursive(root.left);
		System.out.print(root.val + "->");
		inorderRecursive(root.right);

	}

	private static void postorderRecursive(Tree root) {

		if (root == null) {
			return;
		}

		postorderRecursive(root.left);
		postorderRecursive(root.right);
		System.out.print(root.val + " ");

	}

	private static void preorderRecursive(Tree root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + ".");
		preorderRecursive(root.left);
		preorderRecursive(root.right);

	}

}
