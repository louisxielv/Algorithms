package edu.nyu.lx463.questions.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LyuXie on 5/18/17.
 */
public class WordBreak {
    public boolean canBreak(String input, String[] dict) {
        Set<String> set = toSet(dict);
        //dp
        // base case: M[0] = true;
        // induction rule : M[i] = M[j] && set.contains(input.subString(i,j)), j is between 0 ~ i

        boolean[] M = new boolean[input.length() + 1];
        M[0] = true;

        for (int i = 1; i < M.length; i++) {
            M[i] = false;
            for (int j = 0; j < i; j++) {
                if (M[j] && set.contains(input.substring(j, i))) {
                    M[i] = true;
                    break;
                }
            }
        }

        return M[M.length - 1];
    }

    private Set<String> toSet(String[] array) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        return set;
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        boolean result = wb.canBreak("abccdde", new String[]{"abc","ab","cd","de","def"});
        System.out.print(result);
    }
}
