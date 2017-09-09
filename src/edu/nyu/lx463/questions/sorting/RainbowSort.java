package edu.nyu.lx463.questions.sorting;

/**
 * Created by LyuXie on 3/23/17.
 */
public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        // Write your solution here.
        if (array.length == 0) {
            return array;
        }

        int i = 0, j = 0, k = array.length - 1;
        while (j <= k) {
            if (array[j] == -1) {
                swap(array, i, j);
                i++;
                j++;
            }
            else if (array[j] == 0) {
                j++;
            }
            else if (array[j] == 1) {
                swap(array, j, k);
                k--;
            }
        }

        return array;
    }

    private int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }
}
