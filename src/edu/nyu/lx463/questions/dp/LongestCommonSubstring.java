package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 6/24/17.
 */
public class LongestCommonSubstring {
    public String longestCommon(String s, String t) {
        // Write your solution here.
        // use DP
        // M[i][j] represents the common substring s start at i, t start at j
        // induction rule: if s[i] = s[j], M[i][j] = M[i - 1][j - 1] + 1
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        int[][] M = new int[sa.length][ta.length];

        int start = 0;
        int longest = 0;

        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < ta.length; j++) {
                if (sa[i] == ta[j]) {
                    if (i == 0 || j == 0) {
                        M[i][j] = 1;
                    }
                    else {
                        M[i][j] = M[i - 1][j - 1] + 1;
                    }
                }

                if (M[i][j] > longest) {
                    longest = M[i][j];
                    start = i - longest + 1;
                }
            }
        }

        return new String(sa, start, longest);

    }

    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String result = lcs.longestCommon("abcde", "cdef");
        System.out.println(result);
    }
}
