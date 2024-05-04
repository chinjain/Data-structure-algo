package strings_problem;

public class Reverse_String_Recursion {

	public static void main(String[] args) {

		String s = "Chinmay";

		String answer = reverse(s);
		System.out.println(answer);

	}

	/*
	 * 
	 * 1. Extract the substring from the string 2. append the same !!
	 * 
	 * 
	 * 
	 * 
	 */

	private static String reverse(String s) {

		if (s.length() <= 1 || s == null) {
			return s;
		}

		return reverse(s.substring(1)) + s.charAt(0);
	}

}
