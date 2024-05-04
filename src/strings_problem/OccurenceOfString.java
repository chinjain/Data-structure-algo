package strings_problem;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class OccurenceOfString {

	public static void main(String[] args) {

		String str = "Fear leads to anger; anger leads to hatred; hatred leads to conflict; conflict leads to suffering.";

		Map<String, Long> collect = Arrays.stream(str.split(" "))
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

		collect.entrySet().forEach((e) -> {
			System.out.println(e.getKey() + ":" + e.getValue());
		});
	}

}
