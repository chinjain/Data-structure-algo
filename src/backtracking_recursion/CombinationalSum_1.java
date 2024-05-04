package backtracking_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum_1 {

	/*
	 * 
	 * Print all the subset from the array whose sum is equal to the give target
	 * 
	 */

	public static void main(String[] args) {

		int arr[] = { 2, 3, 6, 7 };
		int target = 9;
		Arrays.sort(arr);

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		backtrack(list, new ArrayList<Integer>(), arr, 0, target);

		list.parallelStream().forEach((s) -> {
			System.out.println(s);
		});

	}

	private static void backtrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] arr, int idx, int target) {

		if (target < 0) {
			return;
		} else if (target == 0) {
			list.add(new ArrayList<Integer>(temp));
			return;
		} else {
			for (int i = idx; i < arr.length; i++) {
				if (temp.contains(arr[i]))
					continue;
				temp.add(arr[i]);
				backtrack(list, temp, arr, i + 1, target - arr[i]);
				temp.remove(temp.size() - 1);

			}
		}

	}

}
