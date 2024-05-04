package arrays_problems;

import java.util.Arrays;

public class Dutch_National_Flag_Algortihm {

	public static void main(String[] args) {

		int[] nums = { 2, 0, 2, 1, 1, 0 };
		sortColors(nums, nums.length);

	}

	private static void sortColors(int[] arr, int n) {

		int lo = 0, mid = 0, hi = n - 1;

		while (mid <= hi) {
			if (arr[mid] == 0) {
				swap(arr, lo, mid);
				lo++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				swap(arr, mid, hi);
				hi--;
			}
		}
		
		Arrays.stream(arr).forEach(System.out::print);
	}

	private static void swap(int[] arr, int lo, int mid) {
		int temp = arr[lo];
		arr[lo] = arr[mid];
		arr[mid] = temp;
	}

}
