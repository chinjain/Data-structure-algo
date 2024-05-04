package strings_problem;

public class Valid_Palindrome {

	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";

		boolean ans = bruteForce(s);
		System.out.println(ans);

		boolean optimalAns = optimalApprach(s);
		System.out.println(optimalAns);

	}

	private static boolean optimalApprach(String s) {

		if (s.isEmpty()) {
			return false;
		}

		int start = 0;
		int end = s.length() - 1;

		while (start <= end) {

			char currFirst = s.charAt(start);
			char currLast = s.charAt(end);

			if (!Character.isLetterOrDigit(currFirst)) {
				start++;
			} else if (!Character.isLetterOrDigit(currLast)) {
				end--;
			} else {
				if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
					return false;
				}

				start++;
				--end;
			}

		}

		return true;
	}

	private static boolean bruteForce(String s) {

		if (s.isEmpty()) {
			return false;
		}

		s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		StringBuilder sb = new StringBuilder(s).reverse();

		return s.equals(sb.toString());
	}
}
