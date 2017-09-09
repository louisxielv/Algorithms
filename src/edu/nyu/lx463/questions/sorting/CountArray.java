package edu.nyu.lx463.questions.sorting;

/**
 * Created by LyuXie on 7/8/17.
 */
public class CountArray {
    public int[] countArray(int[] array) {
        int[] indexArray = initializeIndexArray(array);
        int[] helperArray = new int[array.length];
        int[] countArray = new int[array.length];
        mergeSort(array, indexArray, helperArray, countArray, 0, array.length - 1);
        return countArray;
    }

    private void mergeSort(int[] array, int[] indexArray, int[] helperArray, int[] countArray, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(array, indexArray, helperArray, countArray, start, mid);
        mergeSort(array, indexArray,helperArray, countArray, mid + 1, end);
        merge(array, indexArray, helperArray, countArray, start, mid, end);
    }

    private void merge(int[] array, int[] indexArray, int[] helperArray, int[] countArray, int start, int mid, int end) {
        copyArray(helperArray, indexArray, start, end);

        int leftStart = start, rightStart = mid + 1;
        while (leftStart <= mid) {
            if (rightStart > end || array[helperArray[leftStart]] <= array[helperArray[rightStart]]) {
                countArray[helperArray[leftStart]] += (rightStart - mid - 1);
                indexArray[start++] = helperArray[leftStart++];
            }
            else {
                indexArray[start++] = helperArray[rightStart++];
            }
        }
    }

    private void copyArray(int[] helperArray, int[] indexArray, int start, int end) {
        for (int i = 0; i < helperArray.length; i++) {
            helperArray[i] = indexArray[i];
        }
    }

    private int[] initializeIndexArray(int[] array) {
        int[] indexArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            indexArray[i] = i;
        }

        return indexArray;
    }

    public static void main(String[] args) {
        CountArray count = new CountArray();
        int[] result = count.countArray(new int[]{1,0,8,7,6,5,9,3});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
