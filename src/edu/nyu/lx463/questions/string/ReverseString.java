package edu.nyu.lx463.questions.string;

/**
 * Created by LyuXie on 4/27/17.
 */
public class ReverseString {
    public String reverse(String input) {
        // Write your solution here.
        if (input.length() == 0 || input.length() == 1) {
            return input;
        }

        char[] array = input.toCharArray();
        int i = 0, j = array.length - 1;

        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }

        return new String(array);
    }

    public String reverse2(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return input;
        }

        char[] array = input.toCharArray();
        reverseStringArray(array, 0, array.length - 1);
        return new String(array);
    }

    private void reverseStringArray(char[] input, int start, int end) {
        if (start >= end) {
            return;
        }

        swap(input, start, end);
        reverseStringArray(input,start + 1, end - 1);
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
