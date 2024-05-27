package sliding_window_problesm;


/*
 * dp - problem
 * 
 */
public class LongestCommonSubstring {

	public static void main(String[] args) {

		String s1 = "abcdef";
		String s2 = "abcxydef";
		System.out.println("Longest Common Substring: " + findLongestCommonSubstring(s1, s2));

	}

	private static String findLongestCommonSubstring(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int maxLength = 0;
		int endIndex = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int k = 0;
				// Keep expanding the substring as long as characters match and within bounds
				while (i + k < n && j + k < m && s1.charAt(i + k) == s2.charAt(j + k)) {
					k++;
				}
				// Update the longest common substring if applicable
				if (k > maxLength) {
					maxLength = k;
					endIndex = i;
				}
			}
		}

		if (maxLength == 0) {
			return ""; // No common substring found
		}
		return s1.substring(endIndex, endIndex + maxLength);
	}
}
