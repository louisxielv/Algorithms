package edu.nyu.lx463.questions.sorting;

import java.awt.geom.QuadCurve2D;

/**
 * Created by LyuXie on 3/22/17.
 */
public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null) {
            return array;
        }

        quickSort(array, 0, array.length -1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = left + (int)(Math.random() * (right - left + 1));
        int pivot = array[pivotIndex];
        swap(array, right, pivotIndex);
        int rightBound = right--;

        while(left <= right) {
            if (array[left] <= pivot) {
                left++;
            }else {
                swap(array, left, right);
                right--;
            }
        }

        swap(array, rightBound, left);
        return left;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] result = new int[]{3,2,5,74,3,5,6,3,6};
        int[] newResult = quickSort.quickSort(result);
        for (int i : newResult) {
            System.out.println(i);
        }

    }


}
