package edu.nyu.lx463.questions.recursion;

/**
 * Created by LyuXie on 5/31/17.
 */
public class RotateMatrix {
    public int[][] rotate(int[][] matrix) {
        // Write your solution here.
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        helper(matrix, matrix.length, 0);
        return matrix;
    }

    private void helper(int[][] matrix, int size, int offset) {
        if (size <= 1) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            int temp = matrix[offset][offset + i];
            matrix[offset][offset + i] = matrix[matrix.length - 1 - offset - i][offset];
            matrix[matrix.length - 1 - offset - i][offset] = matrix[matrix.length - 1- offset][matrix.length - 1 - offset - i];
            matrix[matrix.length - 1- offset][matrix.length - 1 - offset - i] = matrix[offset + i][matrix.length - 1 - offset];
            matrix[offset + i][matrix.length - 1 - offset] = temp;
        }



        helper(matrix, size - 2, offset + 1);
    }

    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();
        int[][] result = rm.rotate(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}});
        for (int[] array: result) {
            for (int i : array) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
