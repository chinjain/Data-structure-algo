package graph;
/*
        Real World Understanding
You have used Paint application on your computer.
There is a bucket tool in Paint. You click on any area and it fills that entire area with a new color. It spreads to all connected cells that have the same original color.
This is exactly Flood Fill.
Real world uses:

Paint bucket tool
Image editing software
Game development — filling regions with color
Google Maps — filling water bodies or landmasses with color


Understanding the Input
You are given:

A 2D grid of numbers where each number represents a color
A starting cell (sr, sc)
A new color to fill with

Your job — from the starting cell, fill all connected cells that have the same color as the starting cell with the new color.
Grid:
1 1 1
1 1 0
1 0 1

Start = (1,1), New Color = 2

Output:
2 2 2
2 2 0
2 0 1

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        //BFS
//        int[][] result = floodFill(image, 1, 1, 2);

        dfs(1,1,image,1,2,image.length,image[0].length);

        for(int[] row : image){
            System.out.println(Arrays.toString(row));
        }

//        System.out.println("Flood Fill Result:");
//        for (int[] row : result) {
//            System.out.println(Arrays.toString(row));
//        }
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        int n = image.length;
        int m = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});

        image[sr][sc] = color;

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                        image[newRow][newCol] == originalColor) {
                    image[newRow][newCol] = color;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        return image;
    }

    static void dfs(int row, int col, int[][] image, int originalColor,
                    int newColor, int n, int m) {

        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != originalColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(row + 1, col, image, originalColor, newColor, n, m);
        dfs(row - 1, col, image, originalColor, newColor, n, m);
        dfs(row, col + 1, image, originalColor, newColor, n, m);
        dfs(row, col - 1, image, originalColor, newColor, n, m);

    }

}
