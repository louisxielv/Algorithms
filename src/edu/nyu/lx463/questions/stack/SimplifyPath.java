package edu.nyu.lx463.questions.stack;

import java.util.*;

/**
 * Created by LyuXie on 7/24/17.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> skipWords = new HashSet<>(Arrays.asList("..", ".", ""));

        for (String s : path.split("/")) {
            if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }else if (!skipWords.contains(s)) {
                stack.push(s);
            }
        }

        String result = "";
        for (String s : stack) {
            result = "/" + s + result;
        }

        return result.isEmpty() ? "/" : result;
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        sp.simplifyPath("/a/./b/../../c/d/e/");
    }
}
