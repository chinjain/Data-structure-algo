package stack_problems;

import java.util.Stack;

public class BalancedParenthesis {

	public static void main(String[] args) {
		String parenthesesSequence = "({[]})";
		if (isBalanced(parenthesesSequence)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

	private static boolean isBalanced(String parenthesesSequence) {
		Stack<Character> stack = new Stack<Character>();

		for (char c : parenthesesSequence.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (!stack.isEmpty() &&  (c == '}' && stack.peek() == '{') || (c == ')' && stack.peek() == '(')
					|| (c == ']' && stack.peek() == '[')) {
				stack.pop();
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

}
