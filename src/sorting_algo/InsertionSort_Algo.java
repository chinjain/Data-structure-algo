package sorting_algo;

import java.util.Arrays;

public class InsertionSort_Algo {

	public static void main(String[] args) {

		int[] arr = { 10, 80, 30, 90, 40 };

		sort(arr, arr.length);

		Arrays.stream(arr).forEach(System.out::println);
	}

	private static void sort(int[] arr, int length) {

		for (int r = 1; r < length; r++) {
			int l = r - 1;
			int key = arr[r];

			while (l >= 0 && key < arr[l]) {
				arr[l + 1] = arr[l];
				--l;
			}

			arr[l + 1] = key;
		}

	}

}
