package strings_problem;

import java.util.Arrays;

public class Longest_Prefix_String {

	public static void main(String[] args) {

		String[] s = {  "gee", "geak", "geezer" };

		bruteForceAppraoch(s);
		betterApproach(s);

	}

	private static void betterApproach(String[] s) {

		Arrays.sort(s); // OnLogN
		StringBuilder prefix = new StringBuilder();

		int i = 0;
		int j = 0;
		String matchStr = s[s.length - 1];

		while (i < s[0].length()) { //O S
			

			if (s[0].charAt(i) == matchStr.charAt(j)) {
				prefix.append(s[0].charAt(i));
				i++;
				j++;

			} else {
				break;
			}
		}

		System.out.println("Longest_Prefix_String.betterApproach()");
		System.out.println(prefix.toString());

	}

	private static void bruteForceAppraoch(String[] s) {

		String prefix = s[0];

		for (int i = 1; i < s.length - 1; i++) {
			String sol = findPrefixWordByWord(prefix, s[i]);
		}

		System.out.println("Longest_Prefix_String.bruteForceAppraoch()");
		System.out.println(prefix);

	}

	private static String findPrefixWordByWord(String prefix, String word) {
		int n1 = prefix.length(), n2 = word.length();
		StringBuilder result = new StringBuilder();
		int i = 0, j = 0;

		while (i < n1 - 1 && j < n2 - 1) {
			if (prefix.charAt(i) != word.charAt(j)) {
				break;
			}
			result.append(prefix.charAt(i));
			i++;
			j++;
		}

		return result.toString();
	}

}
