package strings_problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseEachWord {

	public static void main(String[] args) {

		String s = "Hello World";
//		externalSpachSolution(s);
		naive(s);
		System.out.println("Output: " + reverseEachWord(s));

	}

	static String reverseEachWord(String s) {

		char[] ch = s.toCharArray();
		int start = 0;
		int n = ch.length;

		while (start < n){
			if(ch[start] == ' '){
				start++;
				continue;
			}

			int end = start;

			while (end < n && ch[end] != ' '){
				end++;
			}

			reverse(ch, start, end - 1);

			start = end;
		}

		return new String(ch);
	}

	private static void naive(String s) {
		String[] strings = s.split(" ");
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < strings.length; i++){
			String reversStr = reverse(strings[i]);
			sb.append(reversStr).append(" ");
		}

		System.out.println(sb.toString());

	}
	static void reverse(char[] chars, int left, int right) {
		while (left < right) {
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		}
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

	private static String reverse(String s) {
		int l = 0, r = s.length() - 1;
		char[] ch = s.toCharArray();
		while (l < r) {
			char temp = ch[l];
			ch[l] = ch[r];
			ch[r] = temp;
			l++;
			r--;
		}

		return new String(ch);
	}
}
