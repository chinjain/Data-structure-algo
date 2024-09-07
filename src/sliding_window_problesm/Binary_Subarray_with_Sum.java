	package sliding_window_problesm;

import java.util.HashMap;
import java.util.Map;

public class Binary_Subarray_with_Sum {

	public static void main(String[] args) {

		int[] a = { 1, 0, 1, 0, 1 };
		int goal = 2;

		maxSubarray(a, goal);

	}

	private static void maxSubarray(int[] a, int goal) {
		/*
		 * 
		 * We have already solved this problem with Count subarray with given sum here
		 * we are going to do the same in Binary Array
		 * 
		 * 
		 */

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int cnt = 0;
		int prevSum = 0;

		for (int i = 0; i < a.length; i++) {
			prevSum += a[i];
			cnt += map.getOrDefault(prevSum - goal, 0);

			map.put(prevSum, map.getOrDefault(prevSum, 0) + 1);
		}

		System.out.println("Binary_Subarray_with_Sum.maxSubarray()");
		System.out.println(cnt);

	}

}
