package binary_tree_problesm;

public class Diameter_Binary_Tree {
	
	/*
	 * Approach to solve this problem is : 
	 * 
	 * we need to declare one global variable and update it to the same 
	 * 
	 * We will calculate the left Height of the tree & Right height of the tree
	 * 
	 * and find the max of (max , lh+rh) for that calling node 
	 * 
	 * now we will take the diameter for which we need to find the max of LH & RG + 1 to fetch the value of it
	 * 
	 * 
	 * 
	 * 
	 */


	public static void main(String[] args) {


		Tree root = new Tree(50);
		root.left = new Tree(25);
		root.right = new Tree(75);
		root.left.left = new Tree(12);
		root.left.right = new Tree(37);
		root.left.right.right = new Tree(40);
		root.left.right.left = new Tree(30);
		root.right.left = new Tree(62);
		root.right.right = new Tree(87);
		root.right.left.right = new Tree(70);
		root.right.left.left = new Tree(60);


		int max [] = new int[1];
		optimalSol(root, max);

		System.out.println(max[0]);
	}

	private static int optimalSol(Tree root, int [] max) {

		if(root == null){
			return 0;
		}

		int lh = optimalSol(root.left,max);
		int rh = optimalSol(root.right,max);

		max[0] = Math.max(max[0],lh+rh);

		return 1 + Math.max(lh,rh);
	}

}
