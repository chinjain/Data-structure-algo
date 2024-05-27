package backtracking_recursion;

public class Word_Search {

	public static void main(String[] args) {

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		String word = "ABCCED";

		System.out.println("Word_Search.main()");
		System.out.println(exist(board, word));

	}

	private static boolean exist(char[][] board, String word) {

		int row = board.length;
		int col = board[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (check(board, word, i, j, 0)) {
					return true;
				}
			}
		}

		return false;

	}

	private static boolean check(char[][] board, String word, int i, int j, int curr) {

		if (i < 0 || j > 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(curr)) {
			return false;
		}

		boolean exist = false;
		if (board[i][j] == word.charAt(curr)) {

			board[i][j] += 100;

			exist = check(board, word, i + 1, j, curr + 1) || check(board, word, i - 1, j, curr + 1)
					|| check(board, word, i, j + 1, curr + 1) || check(board, word, i, j - 1, curr + 1);

			board[i][j] -= 100;

		}

		return exist;

	}

}
