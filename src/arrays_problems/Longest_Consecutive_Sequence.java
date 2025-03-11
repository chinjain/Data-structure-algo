package arrays_problems;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {

	public static void main(String[] args) {
		int[] a = { 100, 200, 1, 2, 3, 4 };
		//		bruteForce(a);
		LongestSuccesive(a);
	}

	private static void LongestSuccesive(int[] a) {

		int longest = 1;
		Set<Integer> set = new HashSet<>();

        for (int j : a) {
            set.add(j);
        }

		for (int it : set) {
			if (!set.contains(it - 1)) {
				int cnt = 1;
				int x = it;

				while (set.contains(x + 1)) {
					x = x + 1;
					cnt++;

				}

				longest = Math.max(longest, cnt);
			}
		}

		System.out.println("Longest_Consecutive_Sequence.LongestSuccesive()");
		System.out.println(longest);

	}

	private static void bruteForce(int[] a) {

		int n = a.length;
		int longest = 1;

        for (int j : a) {
            int x = j;
            int cnt = 1;

            while (linearSearch(a, x + 1)) {
                x += 1;
                cnt += 1;
            }

            longest = Math.max(longest, cnt);

        }

		System.out.println("Longest_Consecutive_Sequence.bruteForce()");
		System.out.println(longest);

	}

	private static boolean linearSearch(int[] a, int i) {

		for (int j = 0; j < a.length; j++) {
			if (a[i] == i) {
				return true;
			}
		}

		return false;
	}

}
