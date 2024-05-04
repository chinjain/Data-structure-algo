package sliding_window_problesm;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKCharacter {

	public static void main(String[] args) {

		subStringWithK("abbbbbbc", 3);
	}

	private static void subStringWithK(String s, int k) {

		int ans = 0;
		int i = 0;
		int j = 0;

		Map<Character, Integer> count = new HashMap<Character, Integer>();

		while (true) {
			boolean flag1 = false;
			boolean flag2 = false;

			while (i < s.length()) {
				flag1 = true;
				char ch = s.charAt(i);
				i++;
				count.put(ch, count.getOrDefault(ch, 0) + 1);

				if (count.size() < k) {
					continue;
				} else if (count.size() == k) {
					int len = i - j + 1;

					ans = Math.max(ans, len);
				} else {
					break;
				}
			}

			while (j < i) {
				char ch = s.charAt(j);
				flag2 = true;
				j++;

				if (count.get(ch) == 1) {
					count.remove(ch);
				} else {
					count.put(ch, count.get(ch) - 1);
				}

				if (count.size() == k) {
					int len = i - j + 1;
					ans = Math.max(ans, len);
					break;
				} else if (count.size() > k) {
					continue;
				}
			}

			if (flag1 == false && flag2 == false) {
				break;
			}

		}
		
		System.out.println("LongestSubstringWithAtmostKCharacter.subStringWithK()");
		System.out.println(ans);
	}

}
