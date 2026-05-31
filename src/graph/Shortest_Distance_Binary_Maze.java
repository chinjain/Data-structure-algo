package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Distance_Binary_Maze {

    public static void main(String[] args) {

        int[][] grid1 = {
                {0, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 0}
        };

        System.out.println(shortestPath(grid1, new int[]{0, 0}, new int[]{3, 3}));
    }

    static int shortestPath(int[][] grid, int[] src, int[] dest){

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};

        int n = grid.length;
        int m = grid[0].length;

        if(grid[src[0]][src[1]] == 1 ||  grid[dest[0]][dest[1]] == 1)
            return -1;

        if (src[0] == dest[0] && src[1] == dest[1])
            return 0;

        int[][] dist = new int[n][m];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        dist[src[0]][src[1]] = 0;

        // r,c,dist
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src[0],src[1],0});

        while (!q.isEmpty()){
            int [] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];

            for(int i = 0; i < 4; i++){
                int newRow = r + deltaRow[i];
                int newCol = c + deltaCol[i];

                if(newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < m &&
                        grid[newRow][newCol] == 0 && d + 1 < dist[newRow][newCol]){
                    dist[newRow][newCol] = d + 1;

                    if(newRow == dest[0] && newCol == dest[1])
                        return d + 1;

                    q.offer(new int[]{newRow,newCol,d + 1});
                }
            }
        }
        return  -1;

    }
}
