package strings_problem;

public class IsPalindrome {

	public static void main(String[] args) {

		String s = "chinmay";

		isPalindrome_brute(s);

	}

	static void isPalindrome_brute(String s) {

		char[] ch = s.toCharArray();
		int i = 0;
		int j = ch.length - 1;

		while (i <= j) {
			if (ch[i] != ch[j]) {
				System.out.println("Not palindrome");
				break;
			} else {
				i++;
				j--;
			}
		}

//		System.out.println(s + " is palindrome");

	}
}
