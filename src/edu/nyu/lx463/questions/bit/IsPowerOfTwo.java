package edu.nyu.lx463.questions.bit;

/**
 * Created by LyuXie on 5/2/17.
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int number) {
        // Write your solution here.
        return number > 0 && (number & (number - 1)) == 0;
    }

    public boolean isPowerOfTwoI(int number) {
        // Write your solution here.
        if (number <= 0) {
            return false;
        }

        while ((number & 1) == 0) {
            number = number >>> 1;
        }

        return number == 1;
    }
}
