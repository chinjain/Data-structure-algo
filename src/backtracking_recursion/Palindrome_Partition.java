package backtracking_recursion;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partition {

	public static void main(String[] args) {
		String s = "aabb";
		List<List<String>> list = new ArrayList<List<String>>();

		backtrack(0, new ArrayList<String>(), list, s);

		list.forEach((p) -> {
			System.out.println(p);
		});
	}

	private static void backtrack(int idx, ArrayList<String> temp, List<List<String>> list, String s) {

		if (idx == s.length()) {
			list.add(new ArrayList<String>(temp));
			return;
		}

		for (int i = idx; i < s.length(); i++) {
			if (isPalindrome(s, idx, i)) {
				temp.add(s.substring(idx, i + 1));
				backtrack(i + 1, temp, list, s);
				temp.remove(temp.size() - 1);
			}
		}

	}

	private static boolean isPalindrome(String s, int start, int end) {

		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

}
