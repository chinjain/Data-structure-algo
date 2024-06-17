package sliding_window_problesm;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_window_Maximum {

	public static void main(String[] args) {

		int[] num = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;

		stackApproach_find_next_greater_element_right(num, k);

		deque_approach(num, k);

	}

	private static void deque_approach(int[] num, int k) {
		int res[] = new int[num.length - k + 1];
		int n = num.length;

		Deque<Integer> deque = new ArrayDeque<Integer>();
		for (int i = 0; i < n; i++) {
			// check for the window weather it's in the range or not
			if (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}

			while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
				deque.pollLast();
			}

			deque.offer(i);

			if (i >= k - 1) {
				res[i - k + 1] = num[deque.peek()];
			}
		}

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}

	}

	private static void stackApproach_find_next_greater_element_right(int[] num, int k) {
		// TODO Auto-generated method stub

	}
}
