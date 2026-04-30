package strings_problem;

import java.util.Arrays;

public class ConvertStringToInteger {

	public static void main(String[] args) {

		String str = "12345";

		int res = 0;

		for (int i = 0; i < str.length(); i++) {

			res = res * 10 + str.charAt(i) - '0';
		}

		System.out.println(res);

		char[] alphanumericArray = { 'a', '1', 'b', '2', 'c', '3', 'd', '4', 'e', '5' };
		printNumberFromArray(alphanumericArray);

	}

	private static void printNumberFromArray(char[] alphanumericArray) {

		int res = 0;

        for (char c : alphanumericArray) {
            if (Character.isDigit(c)) {
                res = res * 10 + c - '0';
            }
        }

		System.out.println(res);
	}
}
