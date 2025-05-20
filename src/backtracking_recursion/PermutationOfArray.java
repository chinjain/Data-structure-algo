package backtracking_recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };

		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), arr);

		list.forEach(s ->{
			System.out.println(s + " ");
		});
	}

	private static void backtrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] arr) {

		if (temp.size() == arr.length) {
			list.add(new ArrayList<>(temp));
			return;
		}

        for (int j : arr) {

            if (temp.contains(j))
                continue;
            temp.add(j);
            backtrack(list, temp, arr);
            temp.remove(temp.size() - 1);
        }

	}

}
