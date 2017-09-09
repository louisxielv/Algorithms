package edu.nyu.lx463.questions.hashMap;

import java.util.HashSet;

/**
 * Created by LyuXie on 4/25/17.
 */
public class MissingNumberI {
    public int missing(int[] array) {
        // Write your solution here.
        HashSet<Integer> set = new HashSet<>(array.length);

        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        for (int i = 1; i <= array.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
