package heap_problem;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Last_Stone_Weight {

	public static void main(String[] args) {

		int a[] = { 2, 7, 4, 1 };

		bruteForce(a);
		int ans = optimal(a);
		System.out.println(ans);

		/*
		 * => we will achieve this by making Priority Queue &
		 * 
		 */
	}

	private static int optimal(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

		for (int n : arr) {
			pq.add(n);
		}

		int n = arr.length - 1;

		while (n > 1) {
			int first = pq.remove();
			int second = pq.remove();
			n -= 2;
			int val = Math.abs(first - second);
			pq.add(val);
			n += 1;
		}
		
		
		return pq.isEmpty() ? 0 : pq.peek();

	}

	private static void bruteForce(int[] a) {

		/*
		 * TC : O(nlogn) And we need to inser the new value into the array and sort it
		 * again
		 * 
		 */

		Arrays.sort(a);

	}
}
