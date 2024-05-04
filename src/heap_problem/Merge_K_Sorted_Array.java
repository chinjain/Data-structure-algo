package heap_problem;

public class Merge_K_Sorted_Array {

	public static void main(String[] args) {

		int[][] arr = { { 2, 6, 12, 34 }, { 1, 9, 20, 1000 }, { 23, 34, 90, 2000 } };

		int K = 4;
		int N = 3;
		int[] output = new int[K * N];

		bruteForce(arr, output, N);

	}

	private static void bruteForce(int[][] arr, int[] output, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				output[i+j] = arr[i][j];
			}
		}

	}
}
