package edu.nyu.lx463.questions.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by LyuXie on 6/28/17.
 */
public class LargestHistogram {
    public int largest(int[] array) {
        Deque<Integer> stack = new LinkedList<>();
        int globalMax = 0;
        int i = 0;

        while (i < array.length) {
            if (stack.isEmpty() || array[i] >= array[stack.peekFirst()]) {
                stack.offerFirst(i);
                i++;
            }
            else {
                int height = array[stack.pollFirst()];
                int left;
                left = stack.peekFirst() == null ? -1 : stack.peekFirst();
                globalMax = Math.max(globalMax, (i - left - 1) * height);
            }
        }


        while (!stack.isEmpty()) {
            int height = array[stack.pollFirst()];
            int left;
            left = stack.peekFirst() == null ? -1 : stack.peekFirst();
            globalMax = Math.max(globalMax, (array.length - left - 1) * height);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        LargestHistogram larh = new LargestHistogram();
        int result = larh.largest(new int[]{2, 3, 1});
        System.out.print(result);
    }
}
