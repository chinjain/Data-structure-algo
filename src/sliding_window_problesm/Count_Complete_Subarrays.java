package sliding_window_problesm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Count_Complete_Subarrays {

	public static void main(String[] args) {

		int a[] = { 5, 5, 5, 5 };
		countSubarrays(a, a.length);

		/*
		 * I will count the unique element from the array itself and then will find the
		 * value of the subarray which consist of those unique elements only
		 * 
		 * We will maintain one count variable which will hold the value of total unique
		 * elements from the system by subtracting value n - r(the current window
		 * pointer) + ans(previous window sum).
		 * 
		 */

	}

	private static void countSubarrays(int[] a, int n) {

		int ans = 0, l = 0, r = 0;
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();

		Set<Integer> set = new HashSet<Integer>();
		for (int j : a) {
			set.add(j);
		}

		int k = set.size();

		while (r < n) {
			count.put(a[r], count.getOrDefault(a[r], 0) + 1);

			while (count.size() == k) {
				ans += n - r;
				count.put(a[l], count.get(a[l]) - 1);
				if (count.get(a[l]) == 0) {
					count.remove(a[l]);
				}

				l++;
			}

			r++;
		}

		System.out.println("Count_Complete_Subarrays.countSubarrays()");
		System.out.println(ans);

	}

}
