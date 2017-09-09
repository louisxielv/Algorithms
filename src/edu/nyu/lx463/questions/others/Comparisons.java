package edu.nyu.lx463.questions.others;

/**
 * Created by LyuXie on 5/30/17.
 */
public class Comparisons {
    public int[] largestAndSmallest(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            if (array[i] < array[n - 1 - i]) {
                swap(array, i, n - 1 - i);
            }
        }

        return new int[]{largest(array, 0, n / 2), smallest(array, n / 2, array.length - 1)};
    }

    private int largest(int[] array, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(array[i], max);
        }

        return max;
    }

    private int smallest(int[] array, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(array[i], min);
        }

        return min;
    }

    private void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Comparisons comparisons = new Comparisons();
        int[] result = comparisons.largestAndSmallest(new int[]{2, 1});
        for (int i : result) {
            System.out.print(i);
        }

    }
}
