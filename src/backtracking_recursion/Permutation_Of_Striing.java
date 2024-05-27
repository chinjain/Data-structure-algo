package backtracking_recursion;

public class Permutation_Of_Striing {

	public static void main(String[] args) {

		String s = "ABC";
		permute(s, 0, s.length() - 1);
	}

	private static void permute(String s, int l, int r) {

		if (l == r) {
			System.out.println(s);
		} else {
			for (int i = l; l <= r; l++) {
				s = swap(s, l, i);
				permute(s, l + 1, r);
				s = swap(s, l, i);
			}
		}
	}

	public static String swap(String s, int l, int r) {
		char temp;
		char[] charArray = s.toCharArray();

		temp = charArray[l];
		charArray[l] = charArray[r];
		charArray[r] = temp;
		l++;
		r--;

		return String.valueOf(charArray);
	}

}
