package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    public static void main(String[] args) {
        int[][] grid1 = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(grid1));
    }

    // Time  → O(N×M × log(N×M))
    //Space → O(N×M)

    private static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;


        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0,0,0});

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int effort = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(row == n - 1 && col == m - 1)
                return effort;

            for(int i = 0; i < 4; i++){
                int newRow = deltaRow[i] + row;
                int newCol = deltaCol[i] + col;

                if(newRow >=0 && newRow < n && newCol >= 0 && newCol < m){
                    int newEfort = Math.max(effort, Math.abs(heights[row][col] - heights[newRow][newCol]));

                    if(newEfort < dist[newRow][newCol]){
                        dist[newRow][newCol] = newEfort;
                        pq.offer(new int[]{newEfort,newRow,newCol});
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}
