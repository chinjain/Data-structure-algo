package strings_problem;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagram_String {

	static final int MAX = 256;

	public static void main(String[] args) {

		String s = "cbaebabacd";
		String p = "abc";

		List<Integer> response = new ArrayList<Integer>();

		char[] txt = s.toCharArray();
		char[] patt = p.toCharArray();

		char[] countP = new char[MAX];
		char[] countS = new char[MAX];

		for (int i = 0; i < p.length(); i++) {
			countP[patt[i]]++;
			countS[txt[i]]++;
		}

		for (int i = p.length(); i < s.length(); i++) {
			if (compare(countP, countS)) {
				response.add(i - p.length());
			}

			countS[txt[s.charAt(i)]]++;	

			countP[patt[s.charAt(i - p.length())]]--;
		}
		
		if(compare(countP, countS)) {
			response.add(s.length() - p.length());
		}
		
		
		response.forEach(System.out::println);
		

	}

	public static boolean compare(char[] a1, char[] a2) {
		for (int i = 0; i < MAX; i++) {
			if (a1[i] != a2[i])
				return false;
		}
		return true;
	}
}
