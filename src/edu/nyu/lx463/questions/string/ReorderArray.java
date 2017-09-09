package edu.nyu.lx463.questions.string;

/**
 * Created by LyuXie on 4/27/17.
 */

/*Given an array of elements, reorder it as follow:

        {N1, N2, N3, …, N2k} → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }

        {N1, N2, N3, …, N2k+1} → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }

        Try to do it in place.

        Assumptions

        The given array is not null
        Examples

        {1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }

        {1, 2, 3, 4, 5, 6, 7, 8} → { 1, 5, 2, 6, 3, 7, 4, 8 }

        {1, 2, 3, 4, 5, 6, 7} → { 1, 4, 2, 5, 3, 6, 7 }*/



public class ReorderArray {

    public int[] reorder(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return array;
        }

        if (array.length % 2 == 0) {
            convert(array, 0, array.length - 1);
        }else {
            convert(array, 0, array.length - 2);
        }

        return array;
    }

    private void convert(int[] array, int left, int right) {
        int size = right - left + 1;
        if (size <= 2) {
            return;
        }


        int mid = left + size / 2;
        int leftmid = left + size / 4;
        int rightmid = left + size * 3 / 4;
        reverse(array, leftmid, mid - 1);
        reverse(array, mid, rightmid - 1);
        reverse(array, leftmid,rightmid - 1);

        convert(array, left, left + (leftmid - left) * 2 - 1);
        convert(array, left + (leftmid - left) * 2, right);
    }

    private void reverse(int[] array, int i, int j) {
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        ReorderArray ro = new ReorderArray();
        int[] result = ro.reorder(new int[]{1, 2, 3, 4, 5});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
