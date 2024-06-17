package backtracking_recursion;

import java.util.ArrayList;
import java.util.List;

public class Rat_Maze_Problems {

	public static void main(String[] args) {
		int n = 4;
		int[][] m = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

		List<String> ans = new ArrayList<String>();
		int[][] visit = new int[4][4];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visit[i][j] = 0;
			}
		}

		if (m[0][0] == 1) {
			solve(0, 0, n, m, ans, "", visit);
		}

		if (ans.size() > 0) {
			ans.forEach(str -> {
				System.out.println(str);
			});
		}

		else {
			System.out.println("-1");
		}
	}

	private static void solve(int i, int j, int n, int[][] m, List<String> ans, String move, int[][] visit) {

		if (i == n - 1 && j == n - 1) {
			ans.add(move);
			return;
		}

		visit[i][j] = 1;

		// Down
		if (i + 1 < n && visit[i + 1][j] == 0 && m[i + 1][j] == 1) {
			solve(i + 1, j, n, m, ans, move + "D", visit);
		}

		// left
		if (j - 1 >= 0 && m[i][j - 1] == 1 && visit[i][j - 1] == 0) {
			solve(i, j - 1, n, m, ans, move + "L", visit);
		}
		// right
		if (j + 1 < n && visit[i][j + 1] == 0 && m[i][j + 1] == 1) {
			solve(i, j + 1, n, m, ans, move + "R", visit);
		}
		// up
		if (i - 1 >= 0 && m[i - 1][j] == 1 && visit[i - 1][j] == 0) {
			solve(i - 1, j, n, m, ans, move + "U", visit);
		}
		visit[i][j] = 0;

	}

}
