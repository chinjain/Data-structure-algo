package sliding_window_problesm;

import java.util.HashMap;
import java.util.Map;

public class Binary_Subarray_with_Sum {

	public static void main(String[] args) {

		/*
		Need to find the sum of window where value is equals to the goal or value is K
		 */

		int[] a = { 1, 0, 1, 0, 1 };
		int goal = 2;

		maxSubarray(a, goal);
		bruteForce(a, goal);

	}

	static void bruteForce(int [] a, int tgt){
		int count = 0;

		for(int i = 0; i < a.length; i++){
			int sum = 0;
			for(int j = i; j < a.length; j++) {
				sum += a[j];

				if (sum == tgt)
					count++;
			}
		}

		System.out.println(count);

	}


	private static void maxSubarray(int[] a, int goal) {
		
		/* 
		 * We have already solved this problem with Count sub-array with given sum here
		 * we are going to do the same in Binary Array
		 */
		

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0,1);
		int sum = 0;
		int cnt = 0;

		for(int i = 0; i < a.length; i++){
			sum += a[i];
			int remSum = sum - goal;

			if(map.containsKey(remSum)){
				cnt += map.get(remSum);
			}else{
				map.put(sum, map.getOrDefault(sum,0) + 1);
			}
		}

		System.out.println("Binary_Subarray_with_Sum.maxSubarray()");
		System.out.println(cnt);

	}

}
