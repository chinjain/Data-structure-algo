package arithmetic_code;

import java.util.ArrayList;
import java.util.List;

public class Prime_Number {

	public static void main(String[] args) {

		find_prime_in_range(100);

	}

	private static void find_prime_in_range(int n2) {

		List<Integer> primeNumbers = new ArrayList<Integer>();

		for (int i = 2; i < n2; i++) {
			if (checkPrime(i)) {
				primeNumbers.add(i);
			}
		}

		primeNumbers.forEach(System.out::println);
	}

	private static boolean checkPrime(int n) {

		if (n < 2) {
			return false;
		} else {

			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					return false;
				}
			}
		}

		return true;
	}
}
