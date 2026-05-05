package strings_problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

		HashSet<Character> set = new HashSet<>();

		for (char c : ch) {
			if (!set.contains(c)) {
				sb.append(c);
				set.add(c);
			}
		}
		System.out.println(sb.toString());

	}

	private static void mapApproach(String s) {
		System.out.println("====== MAP ========");
		Map<Character, Long> map = s.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		map.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).forEach(System.out::println);
	}

	private static void optimal(String s) {
		
		System.out.println("");
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
