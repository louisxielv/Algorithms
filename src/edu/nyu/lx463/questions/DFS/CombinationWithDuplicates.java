package edu.nyu.lx463.questions.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LyuXie on 6/16/17.
 */
public class CombinationWithDuplicates {
    public List<String> combine(String set, int k) {
        // Write your solution here.
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);


        StringBuilder sb = new StringBuilder();
        dfs(0, array, result, sb, k);
        return result;
    }

    private void dfs(int index, char[] array, List<String> result, StringBuilder sb, int k) {
        if (sb.length() == k) {
            result.add(sb.toString());
            return;
        }
        if (index >= array.length) {
            return;
        }

        sb.append(array[index]);
        dfs(index + 1, array, result, sb, k);
        sb.deleteCharAt(sb.length() - 1);

        while (index < array.length - 1 && array[index] == array[index + 1]) {
            index++;
        }

        dfs(index + 1, array, result, sb, k);
    }

    public static void main(String[] args) {
        CombinationWithDuplicates sb = new CombinationWithDuplicates();
        List<String> list = sb.combine("abbc", 2);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
