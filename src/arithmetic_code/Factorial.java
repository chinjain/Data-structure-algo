package arithmetic_code;

public class Factorial {

	public static void main(String[] args) {
		
		System.out.println(fact(12));
		
	}

	private static int fact(int i) {
		
		if(i == 0) {
			return 1;
		}
		
		if(i == 1) {
			return 1;
		}
		
		return i * fact(i - 1);
		
		
	}
}
