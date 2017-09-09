package edu.nyu.lx463.questions.string;

/**
 * Created by LyuXie on 4/25/17.
 */
public class RemovingSpace {
    public String removeSpaces(String input) {
        // Write your solution here.
        char[] array = input.toCharArray();
        int slow = 0, fast = 0;
        boolean isFirst = true;

        while (true) {
            while (fast < array.length && array[fast] == ' ') {
                fast ++;
            }

            if (fast == array.length) {
                break;
            }

            if (!isFirst) {
                array[slow++] = ' ';
            }

            while (fast < array.length && array[fast] != ' ') {
                array[slow++] = array[fast++];
            }

            isFirst = false;
        }

        return new String(array, 0, slow);

    }
}
