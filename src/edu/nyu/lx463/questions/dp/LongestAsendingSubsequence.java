package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 7/7/17.
 */
public class LongestAsendingSubsequence {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int[] M = new int[array.length];
        // base case
        M[0] = 1;
        int result = 1;
        for (int i = 1; i < array.length; i++) {
            int value = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    value = Math.max(M[j] + 1, value);
                }
            }
            M[i] = value;
            result = Math.max(result, value);
        }

        return result;
    }

    public int longest2(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int[] refine = new int[array.length];
        refine[0] = array[0];
        int result = 1;
        int pointer = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > refine[pointer]) {
                refine[++pointer] = array[i];
                result = Math.max(result, pointer + 1);
            }else {
                int index = firstBigger(refine, pointer, array[i]);
                refine[index] = array[i];
            }
        }

        return result;
    }

    private int firstBigger(int[] array, int pointer, int target){
        int start = 0, end = pointer;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }

        if (array[start] > target) {
            return start;
        }else {
            return end;
        }
    }

    public static void main(String[] args) {
        LongestAsendingSubsequence las = new LongestAsendingSubsequence();
        System.out.print(las.longest2(new int[]{1,2,4,3,7,6,4,5}));
    }


}
