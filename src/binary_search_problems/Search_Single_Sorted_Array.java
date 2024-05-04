package binary_search_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Search_Single_Sorted_Array {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6));

		bruteForce(arr);
		xorApproach(arr);
		binarySearch(arr);
	}

	private static void binarySearch(ArrayList<Integer> arr) {
		// in BS we need to check that middle element is the single element or not for
		/*
		 * that we look into the preceding and succeding element of arr[mid]
		 */

		int n = arr.size();
		int lo = 0;
		int hi = n;
		System.out.println("Search_Single_Sorted_Array.binarySearch()");

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (!arr.get(mid).equals(arr.get(mid - 1)) && !arr.get(mid).equals(arr.get(mid + 1))) {
				System.out.println(arr.get(mid));
				return;
			}

			// we are in the left
			
			/*
			 * 
			 * we can have the array in the formate of odd-even or even-odd
			 * 
			 */
			if ((mid % 2 == 0 && arr.get(mid).equals(arr.get(mid + 1)))
					|| (mid % 2 == 1 && arr.get(mid).equals(arr.get(mid - 1)))) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}

	}

	private static void xorApproach(ArrayList<Integer> arr) {
		int n = arr.size();
		int ans = 0;

		for (int i = 0; i < n; i++) {
			ans = ans ^ arr.get(i);
		}

		System.out.println("Search_Single_Sorted_Array.xorApproach()");
		System.out.println(ans);

	}

	private static void bruteForce(ArrayList<Integer> arr) {
		int n = arr.size();
		if (n == 1) {
			System.out.println(arr.get(0));
		}

		for (int i = 0; i < n; i++) {

			if (i == 0) {
				// check for the first index
				if (!arr.get(i).equals(arr.get(i + 1))) {
					System.out.println(arr.get(i));
				}
			} else if (i == n - 1) {
				// check for last index
				if (!arr.get(i).equals(arr.get(i - 1))) {
					System.out.println(arr.get(i));
				}
			} else {
				if (!arr.get(i).equals(arr.get(i - 1)) && !arr.get(i).equals(arr.get(i + 1))) {
					System.out.println(arr.get(i));
				}
			}

		}

	}
}
