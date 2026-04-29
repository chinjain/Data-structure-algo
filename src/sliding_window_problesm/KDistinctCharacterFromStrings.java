package sliding_window_problesm;

import java.util.HashMap;
import java.util.Map;

public class KDistinctCharacterFromStrings {

	public static void main(String[] args) {

		String s = "aabc";
		int k = 2;
		find(s, k);
	}

	private static void find(String s, int k) {

		int i = 0;
		int j = 0;
		int ans = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		while (i < s.length()) {

			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			i++;

			while (map.size() > k){
				char c = s.charAt(j);
				if(map.get(c) == 1)
					map.remove(c);
				else
					map.put(c, map.get(c) -1);
				j++;
			}

			ans = Math.max(ans, i - j);
		}

		System.out.println("Substring is :" + s.substring(0, j + 1));

		System.out.println("KDistinctCharacterFromStrings.find()");
		System.out.println(ans);
	}

}
