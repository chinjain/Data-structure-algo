package strings_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Of_Anagram {

	public static void main(String[] args) {

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		List<List<String>> lists = new ArrayList<List<String>>();

		/*
		 * 
		 * Approach we follow here is as follow:
		 * 
		 * 1. we will iterate the array
		 * 
		 * 2. Take one string and sort the character in it
		 * 
		 * 3. make one frequency map and for that str -> [] list of string
		 * 
		 * 4. we will check for the key if it's exist we will add that string to the
		 * corresponding list of the key!!
		 * 
		 */

		approach_1(strs, lists);

		lists.stream().forEach((s) -> System.out.println(s));

	}

	private static void approach_1(String[] strs, List<List<String>> lists) {

		if (strs == null || strs.length == 0) {
			return;
		}

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String s : strs) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);

			String key = new String(ch);

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}

			map.get(key).add(s);

		}

		lists.addAll(map.values());

	}
}
