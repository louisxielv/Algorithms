package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 6/6/17.
 */
public class WoodCut {
    public int minCost(int[] cuts, int length) {
        int[] helper = new int[cuts.length + 2];
        helper[0] = 0;
        for (int i = 0; i < cuts.length; i++) {
            helper[i + 1] = cuts[i];
        }

        helper[helper.length - 1] = length;
        int[][] M = new int[helper.length][helper.length];

        for (int i = 0; i + 1 < helper.length; i++) {
            M[i][i + 1] = 0;
        }

        for (int i = helper.length - 1; i >= 0; i--) {
            for (int j = 0; j < helper.length; j++) {
                if (i >= j - 1) {
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    min = Math.min(M[i][k] + M[k][j] + helper[j] - helper[i], min);
                }
                M[i][j] = min;
            }
        }

        return M[0][helper.length - 1];
    }

    public static void main(String[] args) {
        WoodCut wc = new WoodCut();
        int result = wc.minCost(new int[]{2, 4, 7}, 10);
    }
}
