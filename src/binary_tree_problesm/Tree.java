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

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Tree getLeft() {
		return left;
	}

	public void setLeft(Tree left) {
		this.left = left;
	}

	public Tree getRight() {
		return right;
	}

	public void setRight(Tree right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Tree [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
}
