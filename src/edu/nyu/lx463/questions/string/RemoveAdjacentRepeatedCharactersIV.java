package edu.nyu.lx463.questions.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by LyuXie on 4/25/17.
 */
public class RemoveAdjacentRepeatedCharactersIV {
    // explicitly maintain a stack
    public String deDup(String input) {
        // Write your solution here.
        if (input == null || input.length() <= 1) {
            return input;
        }

        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;

        while (i != input.length()) {
            if (stack.peekFirst() == null || input.charAt(i) != stack.peekFirst()) {
                stack.offerFirst(input.charAt(i));
                i++;
            }
            else {
                while (i < input.length() && input.charAt(i) == stack.peekFirst()) {
                    i++;
                }
                stack.pollFirst();
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pollLast();
        }
        return result;
    }

    // implicitly maintain a stack
    public String deDup2(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        int slow = -1;// including
        int fast = 0;

        char[] array = input.toCharArray();

        while (fast < array.length) {
            if (slow == -1 || array[fast] != array[slow]) {
                array[++slow] = array[fast++];
            }
            else {
                while (fast < array.length && array[slow] == array[fast]) {
                    fast++;
                }
                slow--;
            }
        }
        if (slow == -1) {
            return new String();
        }
        return new String(array, 0, slow + 1);
    }
}
