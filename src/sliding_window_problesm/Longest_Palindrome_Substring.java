package sliding_window_problesm;

public class Longest_Palindrome_Substring {
	public static void main(String[] args) {

		String s = "cbbd";
		bruteForce(s);

		exapndFromCenterApproach(s);
	}

	private static void exapndFromCenterApproach(String s) {

		if (s.length() < 0) {
			return;
		}

		String maxString = s.substring(0, 1);

		for (int i = 0; i < s.length(); i++) {
			String odd = expandFromCenter(s, i, i);
			String even = expandFromCenter(s, i, i + 1);

			if(odd.length() > maxString.length()) {
				maxString = odd;
			}
			if(even.length() > maxString.length()) {
				maxString = even;
			}
			
		}

		System.out.println("Longest_Palindrome_Substring.exapndFromCenterApproach()");
		System.out.println(maxString);
	}

	private static String expandFromCenter(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		return s.substring(i + 1, j);
	}

	private static void bruteForce(String s) {

		int n = s.length();
		int maxLen = 1;
		String maxString = s.substring(0, 1);

		for (int i = 0; i < n; i++) {
			for (int j = i + maxLen; j <= n; j++) {

				if (j - i > maxLen && isPalindrome(s.substring(i, j))) {

					maxLen = j - i;
					maxString = s.substring(i, j);
				}

			}
		}

		System.out.println("Longest_Palindrome_Substring.bruteForce()");
		System.out.println(maxString);
		System.out.println(maxLen);

	}

	private static boolean isPalindrome(String substring) {
		int left = 0, right = substring.length() - 1;

		while (left <= right) {
			if (substring.charAt(left) != substring.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

}
