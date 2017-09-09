package edu.nyu.lx463.questions.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LyuXie on 4/23/17.
 */
public class LetterCombinationsPhoneNumber {
    String[] keys = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();

        dfs(result, sb, digits, 0);
        return result;
    }

    private void dfs(List<String> result, StringBuilder sb, String digits, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String cur = keys[Character.getNumericValue(digits.charAt(index))];
        for (int i = 0; i < cur.length(); i++) {
            sb.append(cur.charAt(i));
            dfs(result, sb, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }


    }
}
