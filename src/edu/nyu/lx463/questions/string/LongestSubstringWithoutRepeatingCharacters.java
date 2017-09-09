package edu.nyu.lx463.questions.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by LyuXie on 4/28/17.
 */


/*Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.

        For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.*/
public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        // Write your solution here.
        if (input.length() == 0) {
            return 0;
        }

        if (input.length() == 1) {
            return 1;
        }

        Set<Character> set = new HashSet<>();
        int slow = 0, fast = 0;
        int longest = 0;

        while (fast < input.length()) {
            if (set.contains(input.charAt(fast))) {
                set.remove(input.charAt(slow++));
            }
            else {
                longest = Math.max(longest, fast - slow + 1);
                set.add(input.charAt(fast++));
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        int result = ls.longest("abcabcbbcda");
        System.out.println(result);
    }
}
