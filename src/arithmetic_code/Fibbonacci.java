package arithmetic_code;

public class Fibbonacci {

	public static void main(String[] args) {

		for (int i = 0; i < 8; i++) {
			System.out.println(fibb(i));
		}

	}

	private static int fibb(int i) {
		if (i == 0) {
			return 1;
		}

		if (i == 1 || i == 2) {
			return i;
		}

		return fibb(i - 1) + fibb(i - 2);
	}

}
