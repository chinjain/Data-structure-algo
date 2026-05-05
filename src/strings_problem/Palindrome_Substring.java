package strings_problem;

import java.util.Arrays;
import java.util.List;

public class Palindrome_Substring {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("madam", "hello", "racecar", "java");

		List<String> palindromes = list.stream().filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
				.toList();
		System.out.println(palindromes);
	}

}
