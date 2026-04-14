package strings_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Of_Anagram {

	public static void main(String[] args) {

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		List<List<String>> lists = new ArrayList<>();

		/*

		   Approach we follow here is as follow:

		   1. we will iterate the array

		   2. Take one string and sort the character in it

		   3. make one frequency map and for that str -> [] list of string

		   4. we will check for the key if it's exist we will add that string to the
		   corresponding list of the key!!

		 */

		//brute force:

		for(int i = 0; i < strs.length; i++){
			char[] key = strs[i].toCharArray();
			Arrays.sort(key);
			String sortedKey = new String(key);
			List<String> res = new ArrayList<>();
			res.add(strs[i]);

			for(int j = 1; j < strs.length; j++){

				char[] ch = strs[i].toCharArray();
				Arrays.sort(ch);

				if(sortedKey.equals(new String(ch))){

				}
			}
		}

		approach_1(strs, lists);

		lists.forEach(System.out::println);

	}

	private static void approach_1(String[] strs, List<List<String>> lists) {

		if (strs == null || strs.length == 0) {
			return;
		}

		Map<String, List<String>> map = new HashMap<>();

		for (String s : strs) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);

			String key = new String(ch);

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(s);

		}
		lists.addAll(map.values());
	}
}
