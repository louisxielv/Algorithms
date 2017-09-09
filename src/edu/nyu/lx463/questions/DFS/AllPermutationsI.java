package edu.nyu.lx463.questions.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LyuXie on 4/17/17.
 */
public class AllPermutationsI {
    public List<String> permutations(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        dfs(set, result, sb, 0);
        return result;
    }

    private void dfs (String set, List<String> result, StringBuilder sb, int index) {
        if (index == set.length()) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < set.length(); i++) {
            if (sb.toString().contains(set.substring(i, i + 1))) {
                continue;
            }

            sb.append(set.charAt(i));
            dfs(set, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
