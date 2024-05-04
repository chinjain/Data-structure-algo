package sliding_window_problesm;

public class Maximum_Consequtive_One {

	public static void main(String[] args) {

		/*
		 * No of flips we can perform is K times and then we have to give the longest
		 * length of the array containing 1's
		 * 
		 */

		int arr[] = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		int k = 3;

		code_optimal(arr, k);

	}

	private static void code_optimal(int[] arr, int k) {

		int max = 0;
		int j = 0;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count++;
			}

			while (count > k) {

				if (arr[j] == 0) {
					count--;
				}
				j++;

			}

			max = Math.max(max, i - j + 1);
		}

		System.out.println(max);

	}

}
