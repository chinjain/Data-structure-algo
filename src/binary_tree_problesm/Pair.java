package binary_tree_problesm;

public class Pair {

	private Tree node;
	private int value;

	public Pair(Tree root, int val) {
		this.node = root;
		this.value = val;
	}

	public Tree getNode() {
		return node;
	}

	public void setNode(Tree node) {
		this.node = node;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
