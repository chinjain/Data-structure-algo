
public class Search_2D_Arrays {

	public static void main(String[] args) {

		bruteForce();
		optimal();
	}

	private static void optimal() {
		int[][] mat = {{1, 5, 9},
				{14, 20, 21},
				{30, 34, 43}};
		int x = 14;

		int lo = 0, hi = mat.length * mat[0].length - 1;

		while (lo <= hi){
			int mid = lo + (hi - lo) / 2;

			int val = mat[mid / mat.length][mid % mat[0].length];

			if(val == x){
				System.out.println("I found it " + val);
				break;
			}
			if(val > x){
				hi = mid - 1;
			}else {
				lo = mid + 1;
			}
		}
	}

	private static void bruteForce() {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 20, 30, 34, 60 } };
		int target = 3;

		int row = matrix.length;
		int col = matrix[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == target) {
					System.out.println("Search_2D_Arrays.bruteForc()");
					System.out.println("FOUND");
					break;
				}
			}
		}
	}

}
