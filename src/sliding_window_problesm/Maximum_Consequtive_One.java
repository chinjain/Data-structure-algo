package sliding_window_problesm;

import java.util.HashMap;
import java.util.Map;

public class Maximum_Consequtive_One {

	public static void main(String[] args) {

		/*
		 * No of flips we can perform is K times and then we have to give the longest
		 * length of the array containing 1's
		 * 
		 */

		int arr[] = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		int k = 3;

		code_optimal(arr, k);
		window(arr, k);

	}

	private static void window(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxOccurence = 0;
		int j = 0;
		int res = 0;
		for (int i = 0; i < arr.length; i++) {

			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			maxOccurence = Math.max(maxOccurence, map.get(arr[i]));

			while (i - j + 1 - maxOccurence > k) {
				if (map.get(arr[j]) == 1) {
					map.remove(arr[j]);
				}
				map.put(arr[j], map.get(arr[j]) - 1);
				j++;
			}

			res = Math.max(res, i - j + 1);

		}

		System.out.println("Maximum_Consequtive_One.window()");
		System.out.println(res);

	}

	private static void code_optimal(int[] arr, int k) {

		int max = 0;
		int j = 0;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count++;
			}

			while (count > k) {
				
				if (arr[j] == 0) {
					count--;
				}
				j++;

			}

			max = Math.max(max, i - j + 1);
		}

		System.out.println(max);

	}

}
