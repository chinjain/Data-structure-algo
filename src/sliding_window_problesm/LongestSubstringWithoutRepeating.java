package sliding_window_problesm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

	public static void main(String[] args) {

		String str = "pwwkew";

		longestSubstring(str);
		bruteforce(str);
		
		hashSetApproach(str);

	}

	private static void hashSetApproach(String str) {
		
		int l = 0;
		int ans = Integer.MIN_VALUE;
		Set<Character> set = new HashSet<Character>();
		
		for(int r = 0; r < str.length(); r++) {
			if(set.contains(str.charAt(r))) {
				while(l < r && set.contains(str.charAt(r))) {
					set.remove(str.charAt(l++));
				}
			}
			
			set.add(str.charAt(r));
			ans = Math.max(ans, r - l + 1);
		}
		
		System.out.println("LongestSubstringWithoutRepeating.hashSetApproach()");
		System.out.println(ans);
		
	}

	private static void bruteforce(String str) {
		
		// Time Complexity that will be around O(n^2)
		int maxlen = 0;
		int n = str.length();

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (allUnique(str, i, j)) {
					maxlen = Math.max(maxlen, j - i);
				}
			}
		}

		System.out.println("LongestSubstringWithoutRepeating.bruteforce()");
		System.out.println(maxlen);

	}

	private static boolean allUnique(String str, int i, int j) {
		HashSet<Character> characters = new HashSet<Character>();

		for (int start = i; start < j; start++) {
			char ch = str.charAt(start);
			if (characters.contains(ch)) {
				return false;
			}

			characters.add(ch);
		}

		return true;
	}

	private static void longestSubstring(String str) {
		int ans = 0;
		int i = 0;
		int j = 0;

		int len = str.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		while (i < len) {

			boolean f1 = false;
			boolean f2 = false;

			while (i < len) {
				f1 = true;
				char ch = str.charAt(i);
				i++;
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				if (map.get(ch) == 2) {
					break;
				} else {
					ans = Math.max(ans, i - j);
				}
			}

			while (j < i) {
				f2 = true;
				char ch = str.charAt(j);
				j++;

				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 1) {
					break;
				} else {
					continue;
				}
			}

			if (f1 == false && f2 == false) {
				break;
			}

		}

		System.out.println("LongestSubstringWithoutRepeating.longestSubstring()");
		System.out.println(ans);

	}

}
