package sliding_window_problesm;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKCharacter {

	public static void main(String[] args) {

		brute("abbbbbbc", 3);
		approach2("abbbbbbc", 3);
	}

	static void brute(String s, int k){
		int ans = 0;

		for(int i = 0; i < s.length(); i++){
			Map<Character,Integer> freq = new HashMap<>();
			for(int j = i; j < s.length(); j++){
				char c = s.charAt(j);
				freq.put(c, freq.getOrDefault(c,0) + 1);
				if(freq.size() == k){
					ans = Math.max(ans, j - i + 1);
				}
			}
		}

		System.out.println(ans);

	}

	private static void approach2(String s, int k) {

		int left = 0;
		int kLength = 0;
		Map<Character, Integer> count = new HashMap<>();

		for (int right = 0; right < s.length(); right++) {
			char r_char = s.charAt(right);
			count.put(r_char, count.getOrDefault(r_char, 0) + 1);

			while (count.size() > k) {
				char l_char = s.charAt(left);
				count.put(l_char, count.get(l_char) - 1);
				if (count.get(l_char) == 0) {
					count.remove(l_char);
				}
				left++;
			}
			
			kLength = Math.max(kLength, right - left + 1);
		}
		
		System.out.println("LongestSubstringWithAtmostKCharacter.approach2()");
		System.out.println(kLength);

	}

}
