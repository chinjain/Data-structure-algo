package strings_problem;

import java.util.stream.Collectors;

public class Valid_Anagram {

	public static void main(String[] args) {

		String s = "anagram", t = "nagaram";

//		bruteForce(s, t);
//		betterOptimal(s, t);
		java8Appraoch(s,t);

	}

	private static void java8Appraoch(String s, String t) {

		if(s.length() != t.length()){
			System.out.println("Not anagram");
		}

		String sorrtedS = s.chars().sorted().mapToObj(c -> (char)c).map(String::valueOf).collect(Collectors.joining());
		String sortedT = t.chars().sorted().mapToObj(c -> (char)c).map(String::valueOf).collect(Collectors.joining());

		System.out.println(sorrtedS.equals(sortedT));

	}

	private static void bruteForce(String s, String t) {

		int CONST_CHAR = 256;
		int[] arr = new int[CONST_CHAR];

		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)]++;
		}

		for (int i = 0; i < t.length(); i++) {
			arr[t.charAt(i)]--;
		}

		for (int i = 0; i < CONST_CHAR; i++) {
			if (arr[i] == 1) {
				System.out.println("Valid_Anagram.bruteForce()");
				System.out.println("Not a anagram");
				break;
			}

		}
		System.out.println("Valid_Anagram.bruteForce()");
		System.out.println("Anagram It is");

	}

	/*
	 * Not A good approach fail for test case ac & bb
	 */
	private static void betterOptimal(String s, String t) {

		int s_sum = 0;
		int t_sum = 0;

		if (s.length() != t.length()) {
			System.out.println("Valid_Anagram.betterOptimal()");
			System.out.println("Not a anagram ");
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			s_sum += s.charAt(i);
			t_sum += t.charAt(i);
		}

		if (s_sum == t_sum) {
			System.out.println("Valid_Anagram.betterOptimal()");
			System.out.println("Anagram " + s_sum + " " + t_sum);
		}
	}
}
