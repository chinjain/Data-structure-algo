package strings_problem;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagram_String {

	static final int MAX = 256;

	public static void main(String[] args) {

		String s = "cbaebabacd";
		String p = "abc";

		List<Integer> response = new ArrayList<Integer>();

		int[] count_p = new int[26];
		int[] count_s = new int[26];

		for (int i = 0; i < p.length(); i++) {
			count_p[p.charAt(i) - 'a']++;
			count_s[s.charAt(i) - 'a']++;// fill first window in text
		}

		for (int i = p.length(); i < s.length(); i++) {
			if (compare(count_p, count_s)) {
				response.add(i - p.length());
			}

			count_s[s.charAt(i) - 'a']++;
			count_p[s.charAt(i - p.length() - 'a')]--;

		
		}

		}


	public static int compare(int[] a1, int[] a2) {
		int matchCount = 0;
		for (int i = 0; i < 26; i++) {
			if (a1[i] == a2[i])
				matchCount++;
		}
		return matchCount;
	}
}
