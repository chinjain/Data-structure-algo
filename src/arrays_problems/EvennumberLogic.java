package arrays_problems;

import java.util.Arrays;
import java.util.List;

public class EvennumberLogic {

	public static void main(String[] args) {

		List<Integer> arr = Arrays.asList(1, 4, 3, 7, 9);
		double average = arr.stream().filter(x -> x % 2 == 0).mapToInt(i -> i).average().getAsDouble();

		System.out.println(average);

		evenNumberWithoutAnyOperator(arr);

	}

	private static void evenNumberWithoutAnyOperator(List<Integer> arr) {
		/*
		 * here we will use the Bit manipulation and apply the logic to find the
		 */

		System.out.println("EvennumberLogic.evenNumberWithoutAnyOperator()");
		for (int num : arr) {
			if ((num & 1) == 0) {
				System.out.println(num);
			}
		}

	}

}
