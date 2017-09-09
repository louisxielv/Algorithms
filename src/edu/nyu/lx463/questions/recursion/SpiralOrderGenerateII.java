package edu.nyu.lx463.questions.recursion;

/**
 * Created by LyuXie on 5/12/17.
 */
public class SpiralOrderGenerateII {
    public int[][] spiralGenerate(int m, int n) {
        // Write your solution here.

        int[][] result = new int[m][n];
        helper(result, 0, m, n, 1);
        return result;
    }

    private void helper(int[][] result, int offset, int rowLeft, int columnLeft, int counter) {
        if (rowLeft <= 0 || columnLeft <= 0) {
            return;
        }

        if (rowLeft == 1) {
            for (int i = 0; i < columnLeft; i++) {
                result[offset][i + offset] = counter++;
            }
            return;
        }

        if (columnLeft == 1) {
            for (int i = 0; i < rowLeft; i++) {
                result[offset + i][offset] = counter++;
            }
            return;
        }

        for (int i = 0; i < columnLeft - 1; i++) {
            result[offset][offset + i] = counter++;
        }

        for (int i = 0; i < rowLeft - 1; i++) {
            result[offset + i][result[0].length - 1 - offset] = counter++;
        }

        for (int i = 0; i < columnLeft - 1; i++) {
            result[result.length - 1 - offset][result[0].length - 1 - offset - i ] = counter++;
        }

        for (int i = 0; i < rowLeft - 1; i++) {
            result[result.length - 1 - offset - i][offset] = counter++;
        }

        helper(result, offset + 1, rowLeft - 2, columnLeft - 2, counter);
    }



    public static void main(String[] args) {
        SpiralOrderGenerateII sg = new SpiralOrderGenerateII();
        int[][] result = sg.spiralGenerate(5, 3);


    }
}
