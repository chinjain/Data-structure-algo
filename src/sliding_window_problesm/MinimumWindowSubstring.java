package sliding_window_problesm;

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
		 * b. what we will do create one hashmap and store all the occurence of those
		 * character in that map
		 * 
		 * c.
		 * 
		 * 
		 */

		String s = "ADOBECODEBANC";
		String t = "ABC";

//		mws(s, t);
		optimised(s, t);

	}

	private static void optimised(String s, String t) {

		/*
		 * The appraoch Steps
		 * 
		 * 1. Create one map and store all the character of t
		 * 
		 * 2. then create variable to loop around Start pointer and end pointer
		 * 
		 * 3. matched if any point of time if we get character matched the we will
		 * increament the value
		 * 
		 * 4. minLenght this will make sure the length of the min substring we need to
		 * get the value we WE WILL initialise with max of str.length() + 1;
		 * 
		 */

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char x : t.toCharArray())
			map.put(x, map.getOrDefault(x, 0) + 1);

		int matched = 0;
		int start = 0;
		int minLength = s.length() + 1;

		int subStr = 0;

		for (int end = 0; end < s.length(); end++) {
			char right = s.charAt(end);

			if (map.containsKey(right)) {
				map.put(right, map.get(right) - 1);
				if (map.get(right) == 0)
					matched++;
			}

			while (matched == map.size()) {
				if (minLength > end - start + 1) {
					minLength = end - start + 1;
					subStr = start;
				}

				char deleted = s.charAt(start++);
				if (map.containsKey(deleted)) {
					if (map.get(deleted) == 0) {
						matched--;
					}

					map.put(deleted, map.get(deleted) + 1);
				}
			}
		}

		System.out.println("MinimumWindowSubstring.optimised()");
		System.out.println(s.substring(subStr, subStr + minLength));

	}

	private static void mws(String s, String t) {
		// TODO Auto-generated method stub

		Map<Character, Integer> t_map = new HashMap<Character, Integer>();
		Map<Character, Integer> s_map = new HashMap<Character, Integer>();
		String ans = "";

		for (char ch : t.toCharArray()) {
			t_map.put(ch, t_map.getOrDefault(ch, 0) + 1);
		}

		int matched = 0;
		int minLength = t.length();
		int start = 0;
		int end = 0;
		while (end < s.length()) {

			boolean f1 = false;
			boolean f2 = false;

			while (end < s.length() && matched < minLength) {
				f1 = true;

				char ch = s.charAt(end);
				s_map.put(ch, s_map.getOrDefault(ch, 0) + 1);

				if (s_map.getOrDefault(ch, 0) <= t_map.getOrDefault(ch, 0)) {
					matched++;
				}

			}

			while (start < end && matched == minLength) {
				f2 = true;
				String str = s.substring(start, end + 1);

				if (ans.length() == 0 || str.length() < ans.length()) {
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

			}

			if (f1 == false && f2 == false) {
				break;
			}
		}

		System.out.println(ans);

	}
}
