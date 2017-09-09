package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 7/20/17.
 */
public class RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        // use dp to solve this question
        // M[i][j] means string s from 0 to i, string p from 0 to j can be matched
        // induction rule : M[i][j] = M[i - 1][ j - 1] if p[j] == s[i] || p[j] == .
        //                  M[i][j] = M[i][j - 1]      else if indicate one match
        //                         or M[i][j - 2]      indicate 0 mathch
        //                         or M[i - 1][j]      indicate multiple match

        if (s == null && p == null) {
            return true;
        }
        if (s == null || p == null) {
            return false;
        }


        boolean[][] M = new boolean[s.length() + 1][p.length() + 1];
        M[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*' && i >= 2) {
                M[0][i] = M[0][i - 2];
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    M[i][j] = M[i - 1][j - 1];
                }else if (p.charAt(j - 1) == '*') {
                    if (j >= 2) {
                        if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                            M[i][j] = M[i][j - 2];
                        }else {
                            M[i][j] = M[i][j - 1] || M[i][j - 2] || M[i - 1][j];
                        }
                    }
                }
            }
        }

        return M[s.length()][p.length()];
    }


    public static void main(String[] args) {
        RegularExpressionMatch re = new RegularExpressionMatch();
        System.out.print(re.isMatch("abcd","d*"));
    }
}
