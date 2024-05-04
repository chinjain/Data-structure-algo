package arrays_problems;

public class Second_Largest {

	public static void main(String[] args) {

		int a[] = { 1, 2, 4, 7, 7, 5 };

		betterApproach(a);
		optimalApproach(a);

	}

	private static void optimalApproach(int[] a) {

		/*
		 * if a[i] is large then the large value what we do we wil update the large to
		 * second large and vice versa
		 */

		int large = Integer.MIN_VALUE;
		int second_large = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > large) {
				second_large = large;
				large = a[i];
			} else if (a[i] > second_large && a[i] != large) {
				second_large = a[i];
			}
		}

		System.out.println("Second_Largest.optimalApproach()");
		System.out.println(second_large);

	}

	private static void betterApproach(int[] a) {

		int small = Integer.MAX_VALUE;
		int second_small = Integer.MAX_VALUE;

		int large = Integer.MIN_VALUE;
		int second_large = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {

			small = Math.min(small, a[i]);
			large = Math.max(large, a[i]);
		}

		for (int i = 0; i < a.length; i++) {

			if (a[i] < second_small && a[i] != small) {
				second_small = a[i];
			}

			if (a[i] > second_large && a[i] != large) {
				second_large = a[i];
			}

		}

		System.out.println("Second Small Element is : " + second_small);
		System.out.println("Second Largest Element is : " + second_large);

	}

}
