package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 7/7/17.
 */
public class IntegerPickGame {
    public int largestTotalSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[][] M = new int[array.length][array.length];
        /*
            M[i][j] represents the largest sum of array start from i, end by j
            base case:
            M[i][i] = array[i]
            M[i][i + 1] = Math.max(array[i], array[i + 1])

            induction rule:
            M[i][j] =   Math.max(right, left)
                        case 1 : pick the left one
                       left = array[i] + M[i + 1][j - 1]   if array[i + 1] < array[j]
                             = array[i] + M[i + 2][j]       if array[i + 1] > array[j]

                        case 2 : pick the right one
                       right = array[j] + M[i][j - 2]        if array[j - 1] > array[i]
                             = array[j] + M[i + 1][j - 1] if array[i] > array[j - 1]
         */

        for(int i = 0; i < array.length - 1; i++) {
            M[i][i] = array[i];
            M[i][i + 1] = Math.max(array[i], array[i + 1]);
        }
        M[array.length - 1][array.length - 1] = array[array.length - 1];

        for (int j = 2; j < array.length; j++) {
            for (int i = 0; j + i < array.length; i++) {
                int left, right;
                if (array[i + 1] < array[i + j]) {
                    left = array[i] + M[i + 1][i + j - 1];
                }else {
                    left = array[i] + M[i + 2][i + j];
                }

                if (array[i + j - 1] > array[i]) {
                    right = array[i + j] + M[i][i + j - 2];
                }else {
                    right = array[i + j] + M[i + 1][i + j - 1];
                }

                M[i][i + j] = Math.max(left, right);
            }
        }

        return M[0][array.length - 1];
    }

    public static void main(String[] args) {
        IntegerPickGame ip = new IntegerPickGame();
        System.out.println(ip.largestTotalSum(new int[]{3,2,5,4}));
    }
}
