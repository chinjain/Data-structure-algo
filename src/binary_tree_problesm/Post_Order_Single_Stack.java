package binary_tree_problesm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Post_Order_Single_Stack {

	public static void main(String[] args) {

		/*
		 * 
		 * 
		 * 
		 * Approach to solve the problem is :
		 * 
		 * take one stack and push all the left value into the stack till the node
		 * become null as soon as node become null we will check the last pushed entry
		 * of that stack and check weather it's null or not
		 * 
		 * if null then we will take the top value of the stack and pop it and add into
		 * the list
		 * 
		 * then we will run one loop to check weather node is not equal to the top value
		 * of the stack right node
		 * 
		 * if yes the we will pop and add it into the list
		 * 
		 * else we will make the root to node and continue adding into the stack and
		 * maintain the Post order traversal.s
		 * 
		 * 
		 * 
		 */

		Tree root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.left.left = new Tree(4);

		root.left.right = new Tree(5);

		root.left.right.left = new Tree(8);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		root.right.right.left = new Tree(9);
		root.right.right.right = new Tree(10);

		List<Integer> list = new ArrayList<Integer>();

		list = postorder(root);
		System.out.println(list);
	}

	private static List<Integer> postorder(Tree root) {
		Stack<Tree> stack = new Stack<Tree>();
		ArrayList<Integer> postOrder = new ArrayList<>();

		if (root == null) {
			return postOrder;
		}

		while (root != null || !stack.isEmpty()) {

			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				Tree node = stack.peek().right;
				if (node == null) {
					node = stack.peek();
					stack.pop();
					postOrder.add(node.val);

					while (!stack.isEmpty() && node == stack.peek().right) {
						node = stack.peek();
						stack.pop();
						postOrder.add(node.val);
					}
				} else {
					root = node;
				}

			}
		}

		return postOrder;
	}

}
