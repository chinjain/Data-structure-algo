package sliding_window_problesm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_All_Anagram_String {

	public static void main(String[] args) {

		String s = "abab";
		String p = "ab";

		List anagram = anagram(s, p);

		anagram.forEach(System.out::println);
	}

	private static List anagram(String s, String p) {
		if (p.length() > s.length()) {
			return Collections.EMPTY_LIST;
		}

		List<Integer> ans = new ArrayList<Integer>();
		Map<Character, Integer> source = new HashMap<Character, Integer>();
		Map<Character, Integer> pattern = new HashMap<Character, Integer>();

		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);
			pattern.put(ch, pattern.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < p.length(); i++) {
			char ch = s.charAt(i);
			source.put(ch, source.getOrDefault(ch, 0) + 1);
		}

		int i = p.length();
		int j = 0;

		while (i < s.length()) {
			if (compare(pattern, source)) {
				ans.add(j);
			}

			char charAtI = s.charAt(i);
			source.put(charAtI, source.getOrDefault(charAtI, 0) + 1);
			char ch = s.charAt(j);

			if (source.get(ch) == 1) {
				source.remove(ch);
			} else {
				source.put(ch, source.get(ch) - 1);
			}

			i++;
			j++;

		}

		if (compare(pattern, source) == true) {
			ans.add(j);
		}

		return ans;
	}

	private static boolean compare(Map<Character, Integer> pattern, Map<Character, Integer> source) {

		for (char ch : source.keySet()) {
			if (pattern.getOrDefault(ch, 0) != source.getOrDefault(ch, 0)) {
				return false;
			}
		}

		return true;
	}

}
