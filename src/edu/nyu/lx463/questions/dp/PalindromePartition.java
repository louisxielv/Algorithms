package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 5/30/17.
 */
public class PalindromePartition {
    public int minCut (String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        char[] array = input.toCharArray();
        int[] M = new int[input.length() + 1];

        M[0] = -1;
        M[1] = 0;

        for (int i = 2; i < M.length; i++) {
            int min = i - 1;
            for (int j = i - 1; j >= 0; j--) {
                if (isPalindrome(array, j, i - 1) ){
                    min = Math.min(min, M[j] + 1);
                }
            }
            M[i] = min;
        }

        return M[M.length - 1];
    }





    private boolean isPalindrome(char[] array, int i, int j) {
        while (i < j) {
            if (array[i] != array[j]) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePartition p = new PalindromePartition();
        int result = p.minCut("aab");
        System.out.print(result);
    }
}
