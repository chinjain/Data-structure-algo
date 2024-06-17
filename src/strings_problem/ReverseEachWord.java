package strings_problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseEachWord {

	public static void main(String[] args) {

		String s = "Hello World";
		//		bruteForce(s);
		externalSpachSolution(s);
		reverseStringWordWithoutchangingTheOrder(s);
		wordReverse(s);

	}

	private static void wordReverse(String s) {

		String[] str = s.split(" ");
		StringBuffer sb = new StringBuffer();

		for (int i = str.length - 1; i >= 0; --i) {
			sb.append(str[i] + " ");
		}

		System.out.println("ReverseEachWord.wordReverse()");
		System.out.println(sb.toString());

	}

	private static void reverseStringWordWithoutchangingTheOrder(String s) {

		Queue<String> queue = new LinkedList<String>();
		StringBuilder response = new StringBuilder();

		String[] str = s.split(" ");

		int i = str.length - 1;
		while (i >= 0) {
			queue.add(str[i]);
			i--;
		}

		while (!queue.isEmpty()) {
			response.append(queue.poll() + " ");
		}

		System.out.println(response);

	}

	private static void externalSpachSolution(String s) {
		Stack<Character> st = new Stack<Character>();
		StringBuilder builder = new StringBuilder("");

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				st.push(s.charAt(i));
			} else {
				while (st.isEmpty() == false) {
					builder.append(st.pop());
				}
				builder.append(" ");
			}
		}

		while (st.isEmpty() == false) {
			builder.append(st.pop());
		}

		System.out.println("ReverseEachWord.externalSpachSolution()");
		System.out.println(builder.toString());

	}

	private static void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			end--;
			start++;
		}
	}
}
