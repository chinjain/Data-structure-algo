package heap_problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Array {

	public static void main(String[] args) {

		int[][] arr = { { 2, 6, 12, 34 }, { 1, 9, 20, 1000 }, { 23, 34, 90, 2000 } };
		bruteForce(arr);
		optimal(arr);

	}

	private static void bruteForce(int[][] arr) {

		List<Integer> input = new ArrayList<>();

		for(int[] a : arr){
			for(int n : a){
				input.add(n);
			}
		}
		Collections.sort(input);
		System.out.println(input);
	}

	static void optimal(int[][] arr){
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
		List<Integer> result = new ArrayList<>();

		for(int i = 0; i < arr.length; i++){
			if(arr[i].length > 0){
				queue.offer(new int[]{arr[i][0],i,0});
			}
		}

		while (!queue.isEmpty()){
			int[] curr = queue.poll();
			result.add(curr[0]);

			int row = curr[1];
			int col = curr[2];

			if(col + 1 < arr[row].length){
				queue.offer(new int[]{arr[row][col+1],row, col+1});
			}
		}

		System.out.println(result);
	}
}
