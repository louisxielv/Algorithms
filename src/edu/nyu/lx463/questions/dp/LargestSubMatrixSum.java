package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 5/27/17.
 */


/*Given a matrix that contains integers, find the submatrix with the largest sum.

        Return the sum of the submatrix.

        Assumptions

        The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
        Examples

        { {1, -2, -1, 4},

        {1, -1,  1, 1},

        {0, -1, -1, 1},

        {0,  0,  1, 1} }

        the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.*/
public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        int rows = matrix.length;
        int column = matrix[0].length;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            int[] curr = new int[column];
            for (int j = i; j < rows; j++) {
                add(curr, matrix[j]);
                result = Math.max(result, largestSubArraySum(curr));
            }
        }

        return result;
    }

    private int largestSubArraySum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        // use dp
        // base case : M[0] = array[0];
        // induction rule : M[i] represents largest subarray sum from 0th element to ith element including ith element
        // if M[i - 1] > 0 M[i] = array[i] + M[i - 1] else M[i] = array[i]

        int start = 0;
        int solutionStart = 0;
        int solutionEnd = 0;
        int prevSum = array[0];
        int result = array[0];

        for (int i = 1; i < array.length; i++) {
            if (prevSum > 0) {
                prevSum += array[i];
            }
            else {
                prevSum = array[i];
                start = i;
            }

            if (prevSum > result) {
                result = prevSum;
                solutionStart = start;
                solutionEnd = i;
            }
        }

        return result;
    }

    private void add(int[] curr, int[] array) {
        for (int i = 0; i < curr.length; i++) {
            curr[i] += array[i];
        }
    }
}
