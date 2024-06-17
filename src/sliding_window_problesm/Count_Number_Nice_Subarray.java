package sliding_window_problesm;

import java.util.HashMap;
import java.util.Map;

public class Count_Number_Nice_Subarray {

	public static void main(String[] args) {
		/*
		 * 1. We have array and int k we need to find all those subarray which consist
		 * of k odd number in that
		 * 
		 * 2. problem is same as Binary Sum subarray we just have to maintain one var
		 * which will hold the number of odd counter variable
		 */

		int[] a = { 1, 1, 2, 1, 1 };
		int k = 3;

		naiveApproach(a, k);

		int res = 0;
		int count = 0;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);

		for (int i : a) {
			count += i % 2;
			res += map.getOrDefault(count - k, 0);
			map.put(count, map.getOrDefault(count, 0) + 1);
		}

		System.out.println(res);

	}

	private static void naiveApproach(int[] a, int k) {
		int cnt = 0;

		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {

				if (a[j] % 2 != 0) {
					sum++;
				}

				if (sum == k) {
					cnt++;
				}

			}
		}

		System.out.println("Count_Number_Nice_Subarray.naiveApproach()");
		System.out.println(cnt);

	}

}
