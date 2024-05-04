package backtracking_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinational_Sum_11 {

	public static void main(String[] args) {

		int arr[] = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 9;
		Arrays.sort(arr);
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		backtrack(list, new ArrayList<Integer>(), arr, target, 0);

		list.parallelStream().forEach((s) -> {
			System.out.println(s);
		});

	}

	private static void backtrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] arr, int target, int start) {

		if (target < 0) {
			return;
		}

		if (target == 0) {
			list.add(new ArrayList<>(temp));
			return;
		}

		for (int i = start; i < arr.length; i++) {
			if (i > start && arr[i] == arr[i - 1])
				continue;
			if (arr[i] > target)
				break;

			if (temp.contains(arr[i]))
				continue;

			temp.add(arr[i]);
			backtrack(list, temp, arr, target - arr[i], i + 1);
			temp.remove(temp.size() - 1);
		}

	}

}
