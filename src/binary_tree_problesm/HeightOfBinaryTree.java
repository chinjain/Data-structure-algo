package binary_tree_problesm;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {

	/*
	 * 
	 * From root to last leaf node we need to find the height of the Binary Tree
	 * 
	 * From root to leaf distance
	 * 
	 * NOTE: In this we are not taking the edges we are taking the Nodes
	 * 
	 * so in the base case we will return 0;
	 * 
	 * If we carefully see the Question the we depth of a tree is equivalent to
	 * level of the tree
	 * 
	 */

	public static void main(String[] args) {

		Tree root = new Tree(50);
		root.left = new Tree(25);
		root.right = new Tree(75);
		root.left.left = new Tree(12);
		root.left.right = new Tree(37);
		root.left.right.left = new Tree(30);
		root.left.right.right = new Tree(40);
		root.left.right.left = new Tree(30);
		root.right.left = new Tree(62);
		root.right.right = new Tree(87);
		root.right.left.right = new Tree(70);
		root.right.left.left = new Tree(60);

		int h = height(root);
		System.out.println("HeightOfBinaryTree.main()");
		System.out.println(h);

		usingQueueDS(root);
	}

	private static void usingQueueDS(Tree root) {

		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		int level = 0;
		while (queue.size() > 0) {

			int size = queue.size();
			while (size-- > 0) {
				Tree node = queue.poll();

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}

			}

			level++;

		}

		System.out.println("HeightOfBinaryTree.usingQueueDS()");
		System.out.println(level);

	}

	private static int height(Tree root) {

		if (root == null) {
			return 0;
		}

		int lst = height(root.left);
		int rst = height(root.right);
		int max = Math.max(lst, rst);

		return max + 1;

	}

}
