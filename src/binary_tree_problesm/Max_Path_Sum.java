package binary_tree_problesm;

public class Max_Path_Sum {

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {


		// Not a valid approach it will failed the test cases.


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

		 maxPathSum(root);
		 
		 System.out.println("Max_Path_Sum.main()");
		 System.out.println(max);

	}

	private static int maxPathSum(Tree root) {
	//same as Diameter problem changes in call of left and right

		if(root == null)
			return 0;

		int left = Math.
				max(maxPathSum(root.left),0);

		int right = Math.max(maxPathSum(root.right),0) ;

		max = Math.max(right+left+root.val,max);

		return root.val + Math.max(left,right);


	}

}
