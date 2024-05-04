package backtracking_recursion;

public class Fibbonaci {

	static int a = 0, b = 1, c = 0;

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			System.out.print(fib(i) + " ");
		}
	}

	private static int fib(int i) {

		if (i == 0) {
			return 0;
		}

		if (i == 1 || i == 2) {
			return 1;
		}

		return fib(i - 1) + fib(i - 2);

	}

}
