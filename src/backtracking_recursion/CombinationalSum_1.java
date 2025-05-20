package backtracking_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum_1 {
	public static void main(String[] args) {

		int arr[] = { 2, 3, 6, 7 };
		int target = 9;
		Arrays.sort(arr);
		List<List<Integer>> list = new ArrayList<>();
		backtrack_2(0,target,arr,list,new ArrayList<Integer>());
//		backtrack(list, new ArrayList<>(), arr, 0, target);
		list.parallelStream().forEach(System.out::println);
	}

	private static void backtrack_2(int i, int target, int[] arr, List<List<Integer>> list, ArrayList<Integer> temp) {
		if(i == arr.length){
			if(target == 0){
				list.add(new ArrayList<>(temp));
			}
			return;
		}

		if(arr[i] <= target){
			temp.add(arr[i]);
			backtrack_2(i,target - arr[i],arr, list, temp);
			temp.remove(temp.size() - 1);
		}
		backtrack_2(i + 1, target, arr, list, temp);
	}

	private static void backtrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] arr, int idx, int target) {
///int arr[] = { 2, 3, 6, 7 };
		if (target < 0) {
			return;
		}

		if (target == 0) {
			list.add(new ArrayList<>(temp));
			return;
		}

			for (int i = idx; i < arr.length; i++) {
				temp.add(arr[i]);
				backtrack(list, temp, arr, i, target - arr[i]);
				temp.remove(temp.size() - 1);

			}

	}

}
