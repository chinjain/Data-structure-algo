package arrays_problems;

public class Foo {
	
	public static void main(String[] args) {
		foo(1234);
	}

	private static void foo(int i) {
		
		System.out.println(i % 10);
		if(i % 10 != 0) {
			foo(i/10);
		}
		
		System.out.println(i % 10);
		
	}

}
