package edu.nyu.lx463.questions.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LyuXie on 5/12/17.
 */
public class SpiralOrderTraverseII {

    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here.
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0) {
            return result;
        }

        helper(result, matrix, 0, matrix.length, matrix[0].length);
        return result;
    }

    private void helper(List<Integer> result, int[][] matrix, int offset ,int rowLeft, int columnLeft) {
        if (rowLeft <= 0 || columnLeft <= 0) {
            return;
        }
        if (rowLeft == 1) {
            for (int i = 0; i < columnLeft; i++) {
                result.add(matrix[offset][offset + i]);
            }
            return;
        }

        if (columnLeft == 1) {
            for (int i = 0; i < rowLeft; i++) {
                result.add(matrix[offset + i][offset]);
            }
            return;
        }


        for (int i = 0; i < columnLeft - 1; i++) {
            result.add(matrix[offset][i + offset]);
        }

        for (int i = 0; i < rowLeft - 1; i++) {
            result.add(matrix[i + offset][matrix[0].length - 1 - offset]);
        }

        for (int i = 0; i < columnLeft - 1; i++) {
            result.add(matrix[matrix.length - 1 - offset][matrix[0].length - 1 - offset - i]);
        }

        for (int i = 0; i < rowLeft - 1; i++) {
            result.add(matrix[matrix.length - 1 - offset - i][offset]);
        }

        helper(result, matrix, offset + 1, rowLeft - 2, columnLeft - 2);

    }

    public static void main(String[] args) {
        SpiralOrderTraverseII sotII = new SpiralOrderTraverseII();
        List<Integer> result = sotII.spiral(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}});
        for (int i: result) {
            System.out.print(i);
            System.out.print(", ");
        }

    }
}
