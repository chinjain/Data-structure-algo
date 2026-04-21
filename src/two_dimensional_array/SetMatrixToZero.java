package two_dimensional_array;

import java.util.Arrays;

public class SetMatrixToZero {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1},{1,1,1},{1,1,1}};

        bruteForce(matrix);
    }

    static void bruteForce(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    //mark entire row as - 1
                    for(int col = 0; col < m; col++){
                        if(matrix[i][col] != 0)
                            matrix[i][col] = -1;
                    }

                    //mark entire col as -1

                    for(int row = 0; row < m; row++){
                        if(matrix[row][j] != 0)
                            matrix[row][j] = -1;
                    }
                }
            }
        }

        //replace -1 to 0

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
