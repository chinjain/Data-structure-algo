package sliding_window_problesm;


/*
 * dp - problem
 * 
 */
public class LongestCommonSubstring {

	public static void main(String[] args) {

		String s1 = "abcdef";
		String s2 = "abcxyef";
		System.out.println("Longest Common Substring: " + findLongestCommonSubstring(s1, s2));

		dp(s1,s2);

	}

	private static void dp(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n + 1][m + 1];
		int maxLen = 0;

		for(int i = 1; i <= s1.length(); i++){
			for(int j = 1; j <= s2.length(); j++){

				if(s1.charAt(i - 1) == s2.charAt(j - 1)){
					dp[i][j] = 1 + dp[i - 1][j - 1];
					maxLen = Math.max(maxLen, dp[i][j]);
				}else{
					dp[i][j] = 0;
				}
			}
		}

		System.out.println("DP : " + maxLen);

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
