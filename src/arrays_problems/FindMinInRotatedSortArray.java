package arrays_problems;

public class FindMinInRotatedSortArray {

	int i = 10;

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };

		/*
		 * 
		 * Here the concept we are going to use is Binary Search
		 * 
		 * if we take a look into the brute force appraoch then we will look into the
		 * whole array and check if the ans is Math.min(ans,arr[i]);
		 * 
		 * then we will get the response in O(n) time
		 * 
		 * 
		 * But we can solve this problem in O(logN) TC.
		 * 
		 * ___________________________________________________________________________________
		 * 
		 * First, we identify the sorted half of the array. Once found, we determine if
		 * the target is located within this sorted half. If not, we eliminate that half
		 * from further consideration. Conversely, if the target does exist in the
		 * sorted half, we eliminate the other half.
		 * 
		 * 
		 */

		optimalApproach(arr);
	}

	private static void optimalApproach(int[] arr) {

		int lo = 0;
		int hi = arr.length - 1;
		int ans = Integer.MAX_VALUE;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;

			if (arr[lo] <= arr[mid]) {
				ans = Math.min(ans, arr[lo]);
				lo = mid + 1;
			} else {
				ans = Math.min(ans, arr[mid]);
				hi = mid - 1;
			}
		}

		System.out.println("FindMinInRotatedSortArray.optimalApproach()");
		System.out.println(ans);

	}

}
