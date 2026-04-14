package binary_tree_problesm;

public class Tree {

	public int val;
	public Tree left;
    public Tree right;

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
