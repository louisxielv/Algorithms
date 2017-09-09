package edu.nyu.lx463.questions.string;

/**
 * Created by LyuXie on 4/27/17.
 */
public class ILoveYahoo {
    public String reverseWords(String input) {
        // Write your solution here.
        if (input == null || input.length() == 0 || input.length() == 1) {
            return input;
        }

        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);

        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                reverse(array, start, i - 1);
                start = i + 1;
            }
        }

        reverse(array, start, input.length() - 1);

        return new String(array);
    }

    private void reverse(char[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        swap(array, start, end);
        reverse(array, start + 1, end - 1);
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        ILoveYahoo ily = new ILoveYahoo();
        String result = ily.reverseWords("I love Google");
        System.out.println(result);
    }
}
