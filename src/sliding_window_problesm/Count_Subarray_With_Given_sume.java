package sliding_window_problesm;

import java.util.HashMap;
import java.util.Map;

public class Count_Subarray_With_Given_sume {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 4 };
		int k = 3;

		int cnt = bruteforc(arr, k);
		System.out.println("Count_Subarray_With_Given_sume.main()");
		System.out.println(cnt);

		optimised(arr, k);
	}

	private static void optimised(int[] arr, int k) {
		int ans = 0;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int preSum = 0;
		map.put(0, 1);

		for (int i = 0; i < arr.length; i++) {
			preSum += arr[i];
			int remove = preSum - k;
			ans += map.getOrDefault(remove, 0);
			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
		}

		System.out.println("Count_Subarray_With_Given_sume.optimised()");
		System.out.println(ans);

	}

	private static int bruteforc(int[] arr, int k) {
		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];

				if (sum == k) {
					ans++;
				}
			}
		}

		return ans;
	}

}
