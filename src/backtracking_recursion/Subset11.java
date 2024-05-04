package backtracking_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset11 {

	// Need to ignore Duplicate

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2 };

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(arr);
		backtrack(0, arr, new ArrayList<>(), list);

		list.stream().forEach(s -> {
			System.out.println(s);
		});
	}

	private static void backtrack(int id, int[] arr, ArrayList temp, List<List<Integer>> list) {
		
		list.add(new ArrayList<Integer>(temp));
		
		for (int i = id; i < arr.length; i++) {
			if (i != id && arr[i] == arr[i - 1])
				continue;
			temp.add(arr[i]);
			backtrack(id + 1, arr, temp, list);
			temp.remove(temp.size() - 1);
		}
	}

}
