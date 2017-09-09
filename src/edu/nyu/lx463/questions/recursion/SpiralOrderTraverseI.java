package edu.nyu.lx463.questions.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LyuXie on 5/12/17.
 */
public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here.
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0) {
            return result;
        }

        helper(result, matrix, 0, matrix.length);
        return result;
    }

    private void helper(List<Integer> result, int[][] matrix, int offset, int size) {
        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }

        if (size <= 0) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset][i + offset]);
        }

        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[i + offset][matrix.length - 1 - offset]);
        }

        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[matrix.length - 1 - offset][matrix.length - 1 - offset - i]);
        }

        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[matrix.length - 1 - offset - i][offset]);
        }

        helper(result, matrix, offset + 1, size - 2);

    }
}
