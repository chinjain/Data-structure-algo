package arrays_problems;

import java.util.Arrays;

public class Three_Sum {

	public static void main(String[] args) {

		int arr[] = { -1, 0, 1, 2, -1, -4 };
		bruteForce(arr);
		optimalApproach(arr);
		usingSortingApproach(arr);

	}

	private static void usingSortingApproach(int[] arr) {

		quickSort(arr, 0, arr.length - 1);
		int sum = 3;

		for (int i = 0; i < arr.length - 2; i++) {
			int l = i + 1;

			int r = arr.length - 1;

			while (l < r) {
				if (arr[i] + arr[l] + arr[r] == sum) {
					System.out.println("Three_Sum.usingSortingApproach()");
					System.out.print("Triplet is " + arr[i] + ", " + arr[l] + ", " + arr[r]);
					return;
				} else if (arr[i] + arr[l] + arr[r] < sum) {
					l++;
				} else {
					r--;
				}
			}
		}

	}

	private static void quickSort(int[] arr, int i, int j) {

		int part;

		if (i < j) {
			part = partition(arr, i, j);
			quickSort(arr, i, part - 1);
			quickSort(arr, part + 1, j);
		}

	}

	private static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[hi];

		int i = lo - 1;

		for (int j = lo; j < hi; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		swap(arr, i + 1, hi);

		return i + 1;
	}

	private static void swap(int[] arr, int i, int hi) {
		int temp = arr[i];
		arr[i] = arr[hi];
		arr[hi] = temp;

	}

	private static void optimalApproach(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (i != 0 && arr[i] == arr[i - 1])
				continue;

			int j = i + 1;
			int k = arr.length - 1;

			while (j < k) {
				int sum = arr[i] + arr[j] + arr[k];

				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					System.out.println(arr[i] + "" + arr[j] + "" + arr[k]);
					j++;
					--k;
				}
			}
		}

	}

	private static void bruteForce(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {

					if (arr[i] + arr[j] + arr[k] == 0) {
						System.out.println("Three_Sum.bruteForce()");
						System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
					}

				}
			}
		}

	}

}
