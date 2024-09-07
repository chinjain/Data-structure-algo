package arrays_problems;

import java.util.Arrays;

public class Rotate_Array_By_K {

	public static void main(String[] args) {

		/*
		 * 
		 * 
		 * Step 1: Copy the last k elements into the temp array.
		 * 
		 * Step 2: shift n-k elements to the right 
		 * 
		 * Step 3: copy the element from the temp to main array
		 * 
		 * 
		 */

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 2, n = arr.length;

		rotateToRight(arr, k, n);

	}

	private static void rotateToRight(int[] arr, int k, int n) {

		int[] newArr = Arrays.copyOf(arr, arr.length);

		if (n == 0)
			return;

		k = k % n;

		if (k > n) {
			return;
		}

		int[] temp = new int[k];

		for (int i = n - k; i < n; i++) {
			temp[i - n + k] = newArr[i];
		}

		for (int i = n - k - 1; i >= 0; --i) {
			newArr[i + k] = newArr[i];
		}

		for (int i = 0; i < k; i++) {
			newArr[i] = temp[i];
		}

		System.out.println(Arrays.toString(newArr));

	}

}
