package binary_tree_problesm;

public class Tree {

	int val;
	Tree left;
	Tree right;

	public Tree(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "Tree [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
}
