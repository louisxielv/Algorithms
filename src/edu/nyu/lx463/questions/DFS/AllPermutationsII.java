package edu.nyu.lx463.questions.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by LyuXie on 4/28/17.
 */
public class AllPermutationsII {
    public List<String> permutations(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }

        char[] array = set.toCharArray();
        dfs(result, array, 0);
        return result;
    }

    private void dfs(List<String> result, char[] array, int index) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }

        Set<Character> permutated = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (!permutated.contains(array[i])) {
                permutated.add(array[i]);
                swap(array, index, i);
                dfs(result, array, index + 1);
                swap(array, index, i);
            }
        }
    }

    private void swap(char[] array, int i , int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
