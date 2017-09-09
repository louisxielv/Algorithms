package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 5/27/17.
 */

/*Assumptions

        The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
        Examples

        {{0, 0, 0, 0},

        {1, 1, 1, 1},

        {0, 1, 1, 1},

        {1, 0, 1, 1} }

        the largest cross of 1s has arm length 2.*/

public class LargestCross1s {
    public int largest(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int column = matrix[0].length;
        if (column == 0) {
            return 0;
        }

        int[][] leftUp = leftUp(matrix, row, column);
        int[][] rightBottom = rightBottom(matrix, row, column);
        return merge(leftUp, rightBottom, row, column);
    }

    private int[][] leftUp(int[][] matrix, int row, int column) {
        int[][] left = new int[row][column];
        int[][] up = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        left[i][j] = 1;
                        up[i][j] = 1;
                    }else if (i == 0) {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = 1;
                    }else if (j == 0) {
                        left[i][j] = 1;
                        up[i][j] = up[i - 1][j] + 1;
                    }else {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = up[i - 1][j] + 1;
                    }
                }
            }
        }

        merge(left, up, row, column);
        return left;
    }

    private int[][] rightBottom(int[][] matrix, int row, int column) {
        int[][] right = new int[row][column];
        int[][] bottom = new int[row][column];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == row - 1 && j == column - 1) {
                        right[i][j] = 1;
                        bottom[i][j] = 1;
                    }else if (i == row - 1) {
                        right[i][j] = right[i][j + 1] + 1;
                        bottom[i][j] = 1;
                    }else if (j == column - 1) {
                        right[i][j] = 1;
                        bottom[i][j] = bottom[i + 1][j] + 1;
                    }else {
                        right[i][j] = right[i][j + 1] + 1;
                        bottom[i][j] = bottom[i + 1][j] + 1;
                    }
                }
            }
        }

        merge(right, bottom, row, column);
        return right;
    }

    private int merge(int[][] a, int[][] b, int row , int column) {
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                a[i][j] = Math.min(a[i][j], b[i][j]);
                result = Math.max(a[i][j], result);
            }
        }

        return result;
    }
}
