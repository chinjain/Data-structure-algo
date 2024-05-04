package binary_tree_problesm;

public class Kth_Largest_Element_BST {

	/*
	 * 
	 * 
	 * This is the BST
	 * 
	 * all the elements from the root present on left side and
	 * 
	 * greater element present on right side
	 * 
	 * * QUestion approach:
	 * 
	 * we need to check that maintain one counter and maintain one root node and
	 * increase the value of that
	 * 
	 * of counter == k then return that node
	 * 
	 */

	public static void main(String[] args) {

		Tree root = new Tree(4);
		root.left = new Tree(2);
		root.right = new Tree(7);
		root.left.left = new Tree(1);
		root.left.right = new Tree(3);
		root.right.left = new Tree(6);
		root.right.right = new Tree(10);

	}

}
