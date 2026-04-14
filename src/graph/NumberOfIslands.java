package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
    The Core Problem We Are Solving

    When you are standing on a land cell 1, you need to visit all its neighboring land cells.
    But how do you know where the neighbors are?

    A neighbor can be in 4 directions — up, down, left, right.

    Why deltaRow and deltaCol
Think of it like this.
You are standing at position (row, col) on the grid.
         (row-1, col)   → UP
              |
(row, col-1) -- YOU -- (row, col+1)
              |
         (row+1, col)   → DOWN

         Now look at the pattern — the values being added are:
        deltaRow = {-1,  1,  0,  0}
        deltaCol = { 0,  0, -1,  1}
        We stored these values in two arrays so we can loop over all 4 directions cleanly instead of writing 4 separate blocks of code.
 */

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '0', '1'},
                {'1', '0', '0', '1'},
                {'0', '1', '0', '0'},
                {'1', '0', '1', '0'}
        };

        System.out.println("Number of Islands: " + numIslands(grid));

    }

    static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][]visit = new boolean[rows][cols];
        int islands = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visit[i][j] && grid[i][j] == '1'){
                    islands++;
                    bfs(i,j,visit,grid);
                }
            }
        }
        return islands;
    }

    static void bfs(int ro, int co, boolean[][] visit, char[][] grid){
        visit[ro][co] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {ro,co});
        int n = grid.length;
        int m = grid[0].length;

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};

        while (!queue.isEmpty()){
           int[] cell = queue.poll();
           int row = cell[0];
           int col = cell[1];

            // we can move in 4 direction so i < 4

            for(int i = 0; i < 4; i++){
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];

                if(newRow >= 0 && newRow < n &&
                newCol >= 0 && newCol < m && grid[newRow][newCol] == '1' && !visit[newRow][newCol]){
                    queue.add(new int[]{newRow,newCol});
                    visit[newRow][newCol] = true;
                }
            }
        }

    }


    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
