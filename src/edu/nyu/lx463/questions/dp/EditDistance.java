package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 5/18/17.
 */
public class EditDistance {
    public int editDistance(String one, String two) {
        // Write your solution here.
        int[][] f = new int[one.length() + 1][two.length() + 1];

        for (int i = 0; i < f[0].length; i++) {
            f[0][i] = i;
        }

        for (int j = 0; j < f.length; j++) {
            f[j][0] = j;
        }


        for (int i = 1; i < f.length; i++) {
            for (int j = 1; j < f[0].length; j++) {
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                }
                else {
                    f[i][j] = Math.min(f[i - 1][j], Math.min(f[i][j - 1], f[i - 1][j - 1])) + 1;
                }
            }
        }

        return f[one.length()][two.length()];
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        int reuslt = ed.editDistance("abcdef", "bbccf");
    }
}
