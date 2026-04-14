package sliding_window_problesm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Count_Complete_Subarrays {

	public static void main(String[] args) {

		int a[] = { 1, 3, 1, 2, 2 };
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

	static void brute(){
		int[] a = {1,3,1,2,2};
		Set<Integer> set = new HashSet<>();
		int count = 0;

		for(int ele : a)
			set.add(ele);

		int totalEle = set.size();

		for(int i = 0; i < a.length; i++){
			Set<Integer> wind = new HashSet<>();

			for(int j = i; j < a.length; j++){
				wind.add(a[j]);
			}

			if(wind.size() == totalEle)
				count++;
		}

	}

	private static void countSubarrays(int[] a, int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		Set<Integer> set = new HashSet<>();
		for (int j : a) {
			set.add(j);
		}

		int k = set.size();
		int left = 0;
		int count = 0;

		for(int right = 0; right < a.length; right++){
			map.put(a[right], map.getOrDefault(a[right], 0) + 1);

			while (map.size() == k){
				count += n - right;
				int leftVal = a[left];
				map.put(leftVal, map.get(leftVal) - 1);
				if(map.get(leftVal) == 0)
					map.remove(leftVal);

				left++;
			}
		}

		System.out.println("Count_Complete_Subarrays.countSubarrays()");
		System.out.println(count);

	}

}
