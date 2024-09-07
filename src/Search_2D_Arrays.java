
public class Search_2D_Arrays {

	public static void main(String[] args) {

		bruteForc();
		optimal();
	}

	private static void optimal() {
		// TODO Auto-generated method stub

	}

	private static void bruteForc() {
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
