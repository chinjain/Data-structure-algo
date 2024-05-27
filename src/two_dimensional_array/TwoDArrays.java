package two_dimensional_array;

public class TwoDArrays {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, { 11, 12, 13, 14 }, { 30, 31, 32, 33 } };
		int row = arr.length;
		int col = arr[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

}
