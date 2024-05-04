package sorting_algo;

import java.util.Arrays;

public class QuickSortAlgo {

	public static void main(String[] args) {
		int[] arr = { 10, 80, 30, 90, 40 };
		quickSort(arr, 0, arr.length - 1);
		
		Arrays.stream(arr).forEach(System.out::println);
	}

	private static void quickSort(int[] arr, int i, int j) {

		if (i < j) {
			int pivot = partition(arr, i, j);
			quickSort(arr, i, pivot - 1);
			quickSort(arr, pivot + 1, j);
		}

	}

	private static int partition(int[] arr, int lo, int hi) {

		int pivot = arr[hi];
		int i = lo - 1;

		for (int j = lo; j <= hi - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}

		swap(arr, i + 1, hi);

		return i + 1;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
