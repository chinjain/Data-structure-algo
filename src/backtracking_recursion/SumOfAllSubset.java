package backtracking_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfAllSubset {

	public static void main(String[] args) {
		
		List<Integer> arr = Arrays.asList(1,2,3);
		ArrayList<Integer> subset = new ArrayList<Integer>();
		
		subsetSumHelper(0,0,arr,arr.size(),subset);
		
		subset.stream().forEach((s) -> {
			System.out.print(s + " ");
		});
		

	}

	private static void subsetSumHelper(int id, int sum, List<Integer> arr, int size, ArrayList<Integer> subset) {
		
		if(id == size) {
			subset.add(sum);
			return;
		}
		
		subsetSumHelper(id + 1, sum + arr.get(id), arr, size, subset);
		
		subsetSumHelper(id + 1, sum, arr, size, subset);
		
	}

}
