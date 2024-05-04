package sliding_window_problesm;

import java.util.HashMap;
import java.util.Map;

public class LongestReapeatingCharacterReplacement {

	public static void main(String[] args) {

		String s = "AAABBABABABBBC";
		int k = 3;

		solution(s, k);
		usingMap(s, k);

	}

	private static void usingMap(String s, int k) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int l = 0;
		int maxRepeat = 0;
		int res = 0;
		for (int r = 0; r < s.length(); r++) {
			char ch = s.charAt(r);
			if (!map.containsKey(ch)) {
				map.put(ch, 0);
			}

			map.put(ch, map.getOrDefault(ch, 0) + 1);
			maxRepeat = Math.max(maxRepeat, map.get(ch));

			if (r - l + 1 - maxRepeat > k) {
				char forRemove = s.charAt(l);
				map.put(forRemove, map.get(forRemove) - 1);
				l++;
			}

			res = Math.max(res, r - l + 1);
			System.out.println(s.substring(l, r + 1));

		}

		System.out.println("LongestReapeatingCharacterReplacement.usingMap()");
		System.out.println(res);

	}

	private static void solution(String s, int k) {
		int a[] = new int[26];
		int res = 0;
		int max = 0;

		int left = 0;

		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			a[ch - 'A']++;

			max = Math.max(max, a[ch - 'A']);

			// From the give window we are Subtracting the total or max occurence of one
			// char and verifing it weather its < then
			// k or not if yes then continue otherwise remove the char;

			if (right - left + 1 - max > k) {
				a[s.charAt(left) - 'A']--;
				left++;
			}
			res = Math.max(max, right - left + 1);
		}

		System.out.println("LongestReapeatingCharacterReplacement.solution()");
		System.out.println(res);
	}
}
