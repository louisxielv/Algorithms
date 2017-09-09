package edu.nyu.lx463.questions.dp;

import com.sun.scenario.effect.Merge;

/**
 * Created by LyuXie on 6/7/17.
 */
public class MergeStones {
    public int minCost(int[] stones) {
        int[][] M = new int[stones.length][stones.length];

        int[] prefixSum = new int[stones.length + 1];
        int sum = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            sum += stones[i - 1];
            prefixSum[i] = sum;
        }

        for (int i = stones.length - 1; i >= 0; i--) {
            for (int j = 0; j < stones.length; j++) {
                if (i >= j) {
                    continue;
                }

                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int now = M[i][k] + M[k + 1][j] + sum(prefixSum, i, j);
                    min = Math.min(now, min);
                }

                M[i][j] = min;
            }
        }

        return M[0][stones.length - 1];
    }


    private int sum(int[] prefixSum, int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }

    public static void main(String[] args) {
        MergeStones ms = new MergeStones();
        int result = ms.minCost(new int[] {4, 3, 3, 4});
    }
}
