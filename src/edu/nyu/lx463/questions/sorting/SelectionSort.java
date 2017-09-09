package edu.nyu.lx463.questions.sorting;

/**
 * Created by LyuXie on 3/23/17.
 */
public class SelectionSort {
    public int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
