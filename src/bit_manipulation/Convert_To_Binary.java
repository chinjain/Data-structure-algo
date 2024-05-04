package bit_manipulation;

public class Convert_To_Binary {

	public static void main(String[] args) {

		StringBuilder res = new StringBuilder();

		int num = 17;

		while (num > 0) {

			if (num % 2 == 0) {
				res.append("0");
			} else {
				res.append("1");
			}

			num = num / 2;
		}

		System.out.println("Convert_To_Binary.main()");
		System.out.println(res.reverse().toString());
	}

}
