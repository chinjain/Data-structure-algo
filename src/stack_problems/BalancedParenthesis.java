package stack_problems;

import java.util.Stack;

public class BalancedParenthesis {

	public static void main(String[] args) {
		String[] tests = {
				"(())",
				"()[]{}",
				"(]",
				"([)]",
				"{[]}",
				"",        // edge case — empty string
				"(((",     // edge case — only opening
				")))"      // edge case — only closing
		};

		for (String test : tests) {
			System.out.println( test + "-> " + isBalanced(test));
		}

	}

	private static boolean isBalanced(String s) {
		Stack<Character> st = new Stack<>();
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);

			if(ch == '(' || ch == '{' || ch == '['){
				st.push(ch);
			}
			else if(ch == ')' || ch == '}' || ch == ']'){
				if (st.isEmpty()) {
					return false;
				}

				char top = st.pop();
				if(!isMatchingPair(top,ch)){
					return false;
				}
			}
		}

		return st.isEmpty();
	}

	private static boolean isMatchingPair(char open, char close) {

		return  (open == '(' && close == ')') ||
				(open == '{' && close == '}')  ||
				(open == '[' && close == ']');

	}

}
