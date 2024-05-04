package arithmetic_code;

public class Armstrong_Number {

	public static void main(String[] args) {

		int number = 153;
		armstrong(153);

	}

	private static void armstrong(int n) {
		int orgNumber, rem, result = 0, num = 0;

		for (orgNumber = n; orgNumber != 0; orgNumber = orgNumber / 10) {
			++num;
		}

		orgNumber = n;

		while (orgNumber != 0) {

			rem = orgNumber % 10;
			result += Math.pow(rem, num);
			orgNumber = orgNumber / 10;

		}

		if (result == n) {
			System.out.println(result);
		}

	}

}
