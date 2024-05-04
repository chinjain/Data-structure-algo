package strings_problem;

import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class String_split {

	public static void main(String[] args) {

		String s = "091-1234567890";
		s.split("-");
		
		List<String> collect = Pattern.compile("-").splitAsStream(s).collect(Collectors.toList());
		
		StringTokenizer tokenizer = new StringTokenizer(s, "-");
		System.out.println(tokenizer.nextToken());

	}

}
