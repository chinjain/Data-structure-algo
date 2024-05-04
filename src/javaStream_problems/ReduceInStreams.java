package javaStream_problems;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceInStreams {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int num = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * 2).reduce(0, Integer::sum);

		System.out.println(num);

		flatMapExample();

	}

	private static void flatMapExample() {
		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));

		nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList()).forEach(System.out::print);
	}

}
