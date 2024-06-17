package arithmetic_code;

public class ReverseNumber {

	public static void main(String[] args) {

		int x = -1239023;

		boolean isNegative = x < 0;

		x = Math.abs(x);

		int num = 0;
		while (x > 0) {

			num = 10 * num + x % 10;
			x = x / 10;
		}

		num = isNegative ? -num : num;
		
		System.out.println(num);
	}
}
