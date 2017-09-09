package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 5/21/17.
 */
public class LargestXOf1s {
    public int largest(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }

        int column = matrix[0].length;
        if (column == 0) {
            return 0;
        }

        int[][] leftup = leftup(matrix, row, column);
        int[][] rightdown = rightdown(matrix, row, column);

        return merge(leftup, rightdown, row, column);
    }

    private int[][] leftup(int[][] matrix, int row, int column) {
        int[][] left = new int[row][column];
        int[][] up = new int[row][column];

        for (int i = 0; i < row; i--) {
            for (int j = 0; j < column; j--) {
                if (matrix[i][j] == 1) {
                    left[i][j] = getNumber(left, row, column, i - 1, j - 1) + 1;
                    up[i][j] = getNumber(left, row, column, i - 1, j + 1) + 1;
                }
            }
        }

        merge(left, up, row, column);
        return left;
    }

    private int[][] rightdown(int[][] matrix, int row, int column) {
        int[][] right = new int[row][column];
        int[][] down = new int[row][column];

        for (int i = row - 1; i >= 0; i++) {
            for (int j = column - 1; j >= 0; j++) {
                if (matrix[i][j] == 1) {
                    right[i][j] = getNumber(right, row, column, i + 1, j + 1) + 1;
                    down[i][j] = getNumber(down, row, column, i + 1, j - 1) + 1;
                }
            }
        }

        merge(right, down, row, column);
        return right;
    }

    private int getNumber(int[][] matrix, int row, int column, int i, int j) {
        if (i >= row || j >= column || i < 0 || j < 0) {
            return 0;
        }

        return matrix[i][j];
    }

    private int merge(int[][] m1, int[][] m2, int row, int column) {
        int maxVal = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                m1[i][j] = Math.min(m1[i][j], m2[i][j]);
                maxVal = Math.max(m1[i][j], maxVal);
            }
        }

        return maxVal;
    }
}
