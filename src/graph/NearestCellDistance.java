package graph;

    /*
        Real World Understanding
        Imagine you are in a city represented as a grid.
        Some locations have hospitals (represented as 1). Other locations are empty (represented as 0).
        For every empty location — find the minimum distance to the nearest hospital.
        Grid:
        0 0 0
        0 1 0
        0 0 0

        Every 0 cell wants to know — how far is the nearest 1?

        Output:
        2 1 2
        1 0 1
        2 1 2
     */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NearestCellDistance {
    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 1},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] result = nearest_bfs(grid);

        System.out.println("Output:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }

    }

    private static int[][] nearest_bfs(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                // If cell itself is 1 — distance is 0
                if (grid[i][j] == 1) {
                    result[i][j] = 0;
                    continue;
                }

                boolean[][] visited = new boolean[n][m];
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j,0});
                visited[i][j] = true;

                boolean found = false;

                while (!queue.isEmpty()){
                    int[] cell = queue.poll();
                    int ro = cell[0];
                    int co = cell[1];
                    int dist = cell[2];


                    if(grid[ro][co] == 1){
                        result[i][j] = dist;
                        found = true;
                        break;
                    }


                    for(int d = 0; d < 4; d++){
                        int newRow = ro + deltaRow[d];
                        int newCol = co + deltaCol[d];

                        if(newRow >= 0  && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]){
                            queue.add(new int[]{newRow,newCol, dist + 1});
                            visited[newRow][newCol] = true;
                        }
                    }
                }

                if (!found) result[i][j] = -1;

            }
        }

        return result;

    }
}
