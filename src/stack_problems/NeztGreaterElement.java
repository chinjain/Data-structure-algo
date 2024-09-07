package stack_problems;

import java.util.Stack;

public class NeztGreaterElement {

	public static void main(String[] args) {

		int a[] = { 1, 5, 2, 3, 5 };

		fromRight(a);

	}

	private static void fromRight(int[] a) {
		Stack<Integer> st = new Stack<Integer>();

		st.push(0);
		int[] res = new int[a.length];

		for (int i = 1; i < a.length; i++) {

			while (!st.isEmpty() && a[i] > a[st.peek()]) {
				int pos = st.peek();
				res[pos] = a[i];
				st.pop();
			}

			st.push(i);
		}

		while (!st.isEmpty()) {
			int pos = st.peek();
			res[pos] = -1;
			st.pop();
		}

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}
