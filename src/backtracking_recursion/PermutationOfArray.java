package backtracking_recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		backtrack(list, new ArrayList<>(), arr);

		list.stream().forEach(s ->{
			System.out.println(s + " ");
		});
	}

	private static void backtrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] arr) {

		if (temp.size() == arr.length) {
			list.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < arr.length; i++) {

			if (temp.contains(arr[i]))
				continue;
			temp.add(arr[i]);
			backtrack(list, temp, arr);
			temp.remove(temp.size() - 1);
		}

	}

}
