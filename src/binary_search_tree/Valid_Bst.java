package binary_search_tree;

import java.util.Stack;

import binary_tree_problesm.Tree;

public class Valid_Bst {

	public static void main(String[] args) {

		Tree root = new Tree(5);
		root.setLeft(new Tree(1));
		root.setRight(new Tree(4));
		root.getRight().setLeft(new Tree(3));
		root.getRight().setRight(new Tree(6));

		boolean isValid_dfs = dfs(root, null, null);

		System.out.println("isValid_dfs " + isValid_dfs);
		
		
		boolean iterativeSolutions = iterativeSolutions(root);
		
		System.out.println(iterativeSolutions);

	}

	private static boolean iterativeSolutions(Tree root) {
		Stack<Tree> st = new Stack<Tree>();
		
		if(root == null) {
			return true;
		}
		
		Tree pre = null;
		
		while(!st.isEmpty() || root != null) {
			while(root != null) {
				st.push(root);
				root = root.getLeft();
			}
			
			 root = st.pop();
			if(pre != null && root.getVal() <= pre.getVal()) {
				return false;
			}
			
			
			pre = root;
			root = root.getRight();
		}
		
		return true;
		
	}

	private static boolean dfs(Tree root, Integer min, Integer max) {

		if (root == null) {
			return true;
		}

		if ((min != null && root.getVal() <= min) || (max != null && max <= root.getVal())) {
			return false;
		}

		return dfs(root.getLeft(), min, root.getVal()) && dfs(root.getRight(), root.getVal(), max);

	}

}
