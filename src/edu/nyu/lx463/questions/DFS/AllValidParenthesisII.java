package edu.nyu.lx463.questions.DFS;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;

/**
 * Created by LyuXie on 6/15/17.
 */
public class AllValidParenthesisII {
    private static final char[] PS = {'(', ')', '[', ']', '{', '}'};
    // restriction1: right can't be more than left
    // restriction2: every parenthesis has to be pairs(use stack)
    public List<String> validParentheses(int l, int m, int n) {
        List<String> result = new ArrayList<>();
        int[] remain = new int[]{l, l, m, m, n, n};
        int resultLength = (l + m + n) * 2;
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        dfs(result, remain, sb, resultLength, stack);

        return result;
    }

    private void dfs(List<String> result, int[] remain, StringBuilder sb, int resultLength, Deque<Character> stack) {
        if (sb.length() == resultLength) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < PS.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0) {
                    stack.offerFirst(PS[i]);
                    sb.append(PS[i]);
                    remain[i]--;
                    dfs(result, remain, sb, resultLength, stack);
                    remain[i]++;
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pollFirst();
                }
            }else {
                if (remain[i] > remain[i - 1] && stack.peekFirst() == PS[i - 1]) {
                    stack.pollFirst();
                    sb.append(PS[i]);
                    remain[i]--;
                    dfs(result, remain, sb, resultLength, stack);
                    stack.offerFirst(PS[i - 1]);
                    remain[i]++;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        AllValidParenthesisII ii = new AllValidParenthesisII();
        List<String> list = ii.validParentheses(3,1,1);
        for (String string: list) {
            System.out.println(string);
        }
    }
}
