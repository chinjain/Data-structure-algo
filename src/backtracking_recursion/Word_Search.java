package backtracking_recursion;

public class Word_Search {

	public static void main(String[] args) {

		char[][] board = { 
					{ 'A', 'B', 'C', 'E' }, 
					{ 'S', 'F', 'C', 'S' }, 
					{ 'A', 'D', 'E', 'E' } 
				};

		String word = "ABCCED";
		
		boolean exist = exist(board,word);

	}

	private static boolean exist(char[][] board, String word) {
		
		int row = board.length;
		int col = board[0].length;
		int idx = 0;
		
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(board[i][j] == word.charAt(idx)) {
					
				}
			}
		}
		
		return true;
		
		
	}

}
