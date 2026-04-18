package sliding_window_problesm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

	public static void main(String[] args) {

		String str = "geeksforgeeks";

		longestSubstring(str);
		hashSetApproach(str);
		brut_2(str);

	}

	private static void brut_2(String str) {

		int res = 0;

		for(int i = 0; i < str.length();i++){
			boolean[] visit = new boolean[26];

			for(int j = i; j < str.length(); j++){

				if(visit[str.charAt(j) - 'a']){
					break;
				}else {
					res = Math.max(res, j - i +1);
					visit[str.charAt(j) - 'a'] = true;
				}
			}
		}

		System.out.println(res);
	}

	private static void hashSetApproach(String str) {
		
		int l = 0;
		int ans = Integer.MIN_VALUE;
		Set<Character> set = new HashSet<>();
		
		for(int r = 0; r < str.length(); r++) {
				while(l < r &&  set.contains(str.charAt(r))) {
					set.remove(str.charAt(l++));
				}
			set.add(str.charAt(r));
			ans = Math.max(ans, r - l + 1);
		}
		
		System.out.println("LongestSubstringWithoutRepeating.hashSetApproach()");
		System.out.println(ans);
		
	}

	private static void longestSubstring(String str) {
		int ans = 0;
		int i = 0;
		int j = 0;

		int len = str.length();
		Map<Character, Integer> map = new HashMap<>();

		while (i < len) {
			while (i < len) {
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
				char ch = str.charAt(j);
				j++;

				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 1) {
					break;
				}
			}
        }
		System.out.println("LongestSubstringWithoutRepeating.longestSubstring()");
		System.out.println(ans);
	}
}
