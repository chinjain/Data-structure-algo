package sliding_window_problesm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Sliding_window_Maximum {

	public static void main(String[] args) {

		int[] num = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;

//		stackApproach_find_next_greater_element_right(num, k);
//
		deque_approach(num, k);

		brute(num, k);

	}

	static void brute(int[] a, int k){
		int[] result = new int[a.length - k + 1];

		for(int i = 0; i <= a.length - k; i++){
			int max = Integer.MIN_VALUE;

			for(int j = i; j < i + k; j++){
				max = Math.max(max, a[j]);
			}

			result[i] = max;
		}

		System.out.println(Arrays.toString(result));
	}

	private static void deque_approach(int[] num, int k) {
		int[] res = new int[num.length - k + 1];
		int n = num.length;
		int resultIdx = 0;

		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			// check for the window weather it's in the range or not
			while (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}
			while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
				deque.pollLast();
			}
			deque.offer(i);
			if (i >= k - 1) {
				res[resultIdx++] = num[deque.peek()];
			}
		}

		System.out.println("deque_approach " + Arrays.toString(res));

	}
}
