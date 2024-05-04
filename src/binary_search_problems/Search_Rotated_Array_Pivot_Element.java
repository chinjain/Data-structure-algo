package binary_search_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Search_Rotated_Array_Pivot_Element {

	/*
	 * Problem statement:
	 * 
	 * Given an integer array arr of size N, sorted in ascending order (with
	 * distinct values) and a target value k. Now the array is rotated at some pivot
	 * point unknown to you. Find the index at which k is present and if k is not
	 * present return -1.
	 * 
	 */

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
		int n = 9, k = 1;

		bruteForce(arr, n, k);
		optimal(arr, n, k);
	}

	private static void optimal(ArrayList<Integer> arr, int n, int k) {

		int lo = 0;
		int hi = n - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (arr.get(mid) == k) {
				System.out.println(mid);
				return;
			}

			if (arr.get(lo) <= arr.get(mid)) {
				if (arr.get(lo) <= k && k <= arr.get(mid)) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				if (arr.get(mid) <= k && k <= arr.get(hi)) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}

//		System.out.println(-1);

	}

	private static void bruteForce(ArrayList<Integer> arr, int n, int k) {

		for (int i = 0; i < n; i++) {
			if (arr.get(i) == k) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(-1);

	}

}
