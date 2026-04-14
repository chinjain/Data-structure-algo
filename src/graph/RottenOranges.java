package graph;


import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 0},
                {0, 2, 2}
        };

        System.out.println("Minutes: " + orangesRotting(grid));
    }

    private static int orangesRotting(int[][] grid) {
        int freshCount = 0;
        int minutes = 0;

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == 2){
                    queue.add(new int[] {i,j});
                }
                if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};

        while (!queue.isEmpty()){
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for(int j = 0; j < 4; j++){
                    int newRow = row + deltaRow[j];
                    int newCol = col + deltaCol[j];

                    if(newRow >= 0 && newRow < n && newCol >=0 && newCol < m && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        freshCount--;
                        rotted = true;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }

            if(rotted) minutes++;
        }

        return freshCount == 0 ? minutes : -1;

    }
}
