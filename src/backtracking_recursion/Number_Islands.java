package backtracking_recursion;

public class Number_Islands {

	public static void main(String[] args) {

		char[][] grid = {
				{ '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		int islands = numIslands(grid);
		System.out.println(islands);

	}

	static boolean[][] visited;

	private static int numIslands(char[][] grid) {

		visited = new boolean[grid.length][grid[0].length];

		int n = grid.length;
		int m = grid[0].length;
		int totalIslands = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					totalIslands++;
					search(grid, i, j);
				}
			}
		}

		return totalIslands;
	}

	private static void search(char[][] grid, int i, int j) {

		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
			return;

		grid[i][j] = '0';
		search(grid, i + 1, j);
		search(grid, i - 1, j);
		search(grid, i, j + 1);
		search(grid, i, j - 1);

	}

}
