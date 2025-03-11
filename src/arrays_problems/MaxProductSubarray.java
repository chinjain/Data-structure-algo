package arrays_problems;

public class MaxProductSubarray {

	public static void main(String[] args) {

		// int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
		int[] arr = { 2, 5, 6, -1, -2, -4, 0, 0, 0 };
		bruteForce(arr);
		kadaneAlgorithm(arr);
		FinalOptimalApproach(arr);

		// MaxProductSubarray maxProductSubarray = new MaxProductSubarray();

	}

	private static void FinalOptimalApproach(int[] arr) {

		System.out.println("MaxProductSubarray.FinalOptimalApproach()");

		int[] prefix = new int[arr.length];
		int[] suffix = new int[arr.length];
		int res = 1;

		prefix[0] = arr[0];
		suffix[arr.length - 1] = arr[arr.length - 1];

		for (int i = 1; i < arr.length; i++) {
			prefix[i] = prefix[i - 1] * arr[i];
		}

		for (int i = arr.length - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] * arr[i];
		}

		for (int i = 0; i < arr.length; i++) {
			res = Math.max(res, Math.max(prefix[i], suffix[i]));
		}

		System.out.println(res);

	}

	private static void kadaneAlgorithm(int[] arr) {
		int pre = 1, suf = 1;
		int ans = Integer.MIN_VALUE;
		int n = arr.length;

		/*
		 * 
		 * There are some cases for the Pre and suffix that we need to take care
		 * 
		 * 1. all the element are -ve and we have even number of arrays then final
		 * output will be the max prodSubarray
		 * 
		 * 2. if we have half +ve element and half -ve element then final product will
		 * also be the max product array
		 * 
		 * 3. if we have the 0 in the array the there is a chance left side of the array
		 * will be max or right side array will be max
		 * 
		 * 4. we will use the Prefix and Suffic approach to solve this problem
		 * 
		 * we will start doing multiplication of a[i] * prefix
		 * 
		 * suffix = sufficx * a[n - i - 1] // it will take the value from the last
		 * 
		 * then
		 * 
		 * ans = Math.max(ans, Math.max(pre,suffix));
		 * 
		 * 
		 */

		for (int i = 0; i < arr.length; i++) {
			if (pre == 0)
				pre = 1;
			if (suf == 0)
				suf = 1;

			pre *= arr[i];
			suf *= arr[n - i - 1];
			ans = Math.max(ans, Math.max(pre, suf));
		}

		System.out.println("MaxProductSubarray.kadaneAlgorithm()");
		System.out.println(ans);

	}

	private static void bruteForce(int[] arr) {

		int result = arr[0];
		for (int i = 0; i < arr.length; i++) {
			int mul = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				mul *= arr[j];
				result = Math.max(result, mul);

			}

			result = Math.max(result, mul);
		}

		System.out.println("MaxProductSubarray.bruteForce()");
		System.out.println(result);

	}

}
