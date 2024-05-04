package arrays_problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int n = 5;
		int[] arr = { 2, 6, 5, 8, 11 };
		int target = 14;
		betterApproach(arr, n, target);

		optimalApproach2Pointer(arr, n, target);
	}

	private static void optimalApproach2Pointer(int[] arr, int n, int target) {
		int l = 0;
		int r = n - 1;

		while (l < r) {
			int sum = arr[l] + arr[r];
			if (sum == target) {
				System.out.println("TwoSum.optimalApproach2Pointer()");
				System.out.println(l + " " + r);
				break;
			} else if (sum < target) {
				l++;
			} else {
				r--;
			}
		}

	}

	private static void betterApproach(int[] arr, int n, int target) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(target - arr[i])) {
				System.out.println(i + " " + map.get(target - arr[i]));
			}

			map.put(arr[i], i);
		}

	}

}
