package binary_tree_problesm;

public class Validate_Bst {

	public static void main(String[] args) {

		Tree node = new Tree(5);
		node.left = new Tree(1);
		node.right = new Tree(4);
		node.right.left = new Tree(3);
		node.right.right = new Tree(6);

	}

}
