package edu.nyu.lx463.questions.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LyuXie on 4/17/17.
 */
public class AllSubsetsI {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> result = new ArrayList<>();
        if (set == null || set.length() == 0) {
            return result;
        }

        dfs(set, result, 0, "");
        return result;
    }

    private void dfs(String set, List<String> result, int index, String s) {
        if (index == set.length()) {
            result.add(s);
            return;
        }

        s += set.charAt(index);
        dfs(set, result, index + 1, s);
        s = s.substring(0, s.length() - 1);

        dfs(set, result, index + 1, s);
    }
}
