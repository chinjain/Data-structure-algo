package strings_problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Duplicate_Char_String {

	public static void main(String[] args) {
		String s = "geeksforgeeks";

		optimal(s);
		mapApproach(s);
		removeDuplicate(s);

	}

	private static void removeDuplicate(String s) {
		System.out.println("Duplicate_Char_String.removeDuplicate()");
		StringBuffer sb = new StringBuffer();
		char[] ch = s.toCharArray();

		HashSet<Character> set = new HashSet<Character>();

		for (char c : ch) {
			if (!set.contains(c)) {
				sb.append(c);
				set.add(c);
			}
		}
		
		System.out.println(sb.toString());

	}

	private static void mapApproach(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		map.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).forEach(System.out::println);
	}

	private static void optimal(String s) {
		
		System.out.println("Duplicate_Char_String.optimal()");

		char ch[] = s.toCharArray();
		Arrays.sort(ch);
		s = new String(ch);
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1) && sb.indexOf(String.valueOf(s.charAt(i))) == -1) {

				if (sb.length() > 0) {
					sb.append(" ");
				}

				sb.append(s.charAt(i));

			}
		}
		System.out.println(sb.toString());

	}

}
