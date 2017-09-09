package edu.nyu.lx463.questions.string;

/**
 * Created by LyuXie on 5/11/17.
 */
public class StringAbbreviationMatching {
    public boolean match(String input, String pattern) {
        // Write your solution here.
        if (input.length() == 0 && pattern.length() == 0) {
            return true;
        }
        if (input.length() == 0 || pattern.length() == 0) {
            return false;
        }

        char[] inputCharArray = input.toCharArray();
        char[] patternCharArray = pattern.toCharArray();

        return match(inputCharArray, 0, patternCharArray, 0);
    }

    public boolean match(char[] input, int inputIndex, char[] pattern, int patternIndex) {
        if (inputIndex == input.length && patternIndex == pattern.length) {
            return true;
        }
        if (inputIndex >= input.length || patternIndex >= pattern.length) {
            return false;
        }


        if (Character.isDigit(pattern[patternIndex])) {
            int num = 0;

            while(patternIndex < pattern.length && Character.isDigit(pattern[patternIndex])) {
                num = num * 10 + Character.getNumericValue(pattern[patternIndex]);
                patternIndex++;
            }

            return match(input, inputIndex + num, pattern, patternIndex);
        }
        else {
            return pattern[patternIndex] == input[inputIndex] ?
                    match(input, inputIndex + 1, pattern, patternIndex + 1) : false;
        }
    }
}
