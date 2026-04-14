package sliding_window_problesm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {

		/*
		 * 
		 * 
		 * The logic for this code is a. We have 2 Strings and one is larger S and other
		 * one is T we need to find the minimum window from S which consist of all the
		 * character from T
		 * 
		 * b. what we will do create one hashmap and store all the occurrence of those
		 * character in that map
		 * 
		 * c.
		 * 
		 * 
		 */

		String s = "BADNCOBECODEBANC";
		String t = "BANC";

				mws(s, t);
//		bruteForc(s, t);
	}

	private static void bruteForc(String s, String t) {

		String ans = "";
		for(int i = 0; i < s.length(); i++){
			for(int j = i; j < s.length(); j++){
				String sub = s.substring(i, j + 1);

				if(containsAll(sub, t)){
					if(ans.isEmpty() || ans.length() > sub.length()){
						ans = sub;
					}
				}
			}
		}
		System.out.println("Answer is : " + ans);

	}

	private static boolean containsAll(String sub, String t) {
		int[] freq = new int[128];
		Arrays.fill(freq,0);
		for(char c : sub.toCharArray()) freq[c]++;

		for(char c : t.toCharArray()){
			if(freq[c] == 0){
				return false;
			}
		}
		return true;
	}


	private static void mws(String s, String t) {
		Map<Character, Integer> t_map = new HashMap<>();
		Map<Character, Integer> s_map = new HashMap<>();
		String ans = "";

		for (char ch : t.toCharArray()) {
			t_map.put(ch, t_map.getOrDefault(ch, 0) + 1);
		}

		int matched = 0;
		int actualMatch = t.length();
		int start = 0;
		int end = 0;

		while (end < s.length()) {
			boolean f1 = false;
			boolean f2 = false;

			// Expand right
			while (end < s.length() && matched < actualMatch) {
				f1 = true;
				char ch = s.charAt(end);
				s_map.put(ch, s_map.getOrDefault(ch, 0) + 1);
				if (s_map.getOrDefault(ch, 0) <= t_map.getOrDefault(ch, 0)) {
					matched++;
				}
				end++; // ✅ Bug 1 fixed
			}

			// Shrink left
			while (start < end && matched == actualMatch) {
				f2 = true;
				String str = s.substring(start, end);  // ✅ end not end+1

				if (ans.isEmpty() || str.length() < ans.length()) {
					ans = str;
				}

				char ch = s.charAt(start);
				if (s_map.get(ch) == 1) {
					s_map.remove(ch);
				} else {
					s_map.put(ch, s_map.get(ch) - 1);
				}

				if (s_map.getOrDefault(ch, 0) < t_map.getOrDefault(ch, 0)) {
					matched--;
				}
				start++; // ✅ Bug 2 fixed
			}

			if (!f1 && !f2) break;
		}

		System.out.println(ans);
	}
}
