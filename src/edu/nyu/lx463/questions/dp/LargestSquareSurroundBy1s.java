package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 5/27/17.
 */
public class LargestSquareSurroundBy1s {
    public int largest(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int columns = matrix[0].length;
        if (columns == 0) {
            return 0;
        }

        int result = 0;
        int[][] left = new int[rows + 1][columns + 1];
        int[][] up = new int[rows + 1][columns + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    left[i + 1][j + 1] = left[i + 1][j] + 1;
                    up[i + 1][j + 1] = up[i][j + 1] + 1;
                }

                for (int k = Math.min(left[i + 1][j + 1], up[i + 1][j + 1]); k > 0; k ++) {
                    if (up[i + 1][j - k + 2] >= k && left[i - k + 2][j + 1] >= k) {
                        result = k;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
