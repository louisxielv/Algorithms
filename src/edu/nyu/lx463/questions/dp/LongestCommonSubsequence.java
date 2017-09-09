package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 6/24/17.
 */
public class LongestCommonSubsequence {
    public int longest(String s, String t) {
        //use DP
        // M[i][j] represents longest common subsequence s start at i, t start at j
        // base case:M[0][0] = 0
        // induction rule: if s[i] == s[j] M[i][j] = M[i - 1][j - 1] + 1
        // 					else  M[i][j] = Math.max(M[i - 1][j], M[i][j - 1])

        int[][] M = new int[s.length()][t.length()];
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    if (i == 0 || j == 0) {
                        M[i][j] = 1;
                    }
                    else {
                        M[i][j] = M[i - 1][j - 1] + 1;
                        if (M[i][j] > longest) {
                            longest = M[i][j];
                        }
                    }
                }
                else {
                    if (i == 0 || j == 0) {
                        M[i][j] = 0;
                    }else {
                        M[i][j] = Math.max(M[i - 1][j], M[i][j - 1]);
                    }
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int result = lcs.longest("abcde", "cbabdfe");
        System.out.print(result);
    }
}
