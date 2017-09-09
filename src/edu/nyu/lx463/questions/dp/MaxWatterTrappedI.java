package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 6/28/17.
 */
public class MaxWatterTrappedI {
    public int maxTrapped(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int i = 1;
        int j = array.length - 2;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (i <= j) {
            leftMax = Math.max(array[i - 1], leftMax);
            rightMax = Math.max(array[j + 1], rightMax);
            if (leftMax < rightMax) {
                result += Math.max(0, leftMax - array[i]);
                i++;
            }
            else {
                result += Math.max(0, rightMax - array[j]);
                j--;
            }
        }


        return result;

    }

    public int maxTrapped2(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] M1 = new int[array.length];
        M1[0] = Integer.MIN_VALUE;
        int[] M2 = new int[array.length];
        M2[array.length - 1] = Integer.MIN_VALUE;

        for (int i = 1; i < array.length; i++) {
            M1[i] = array[i - 1] > M1[i - 1] ? array[i - 1] : M1[i - 1];
        }

        for (int i = array.length - 2; i >= 0; i--) {
            M2[i] = array[i + 1] > M2[i + 1] ? array[i + 1] : M2[i + 1];
        }

        int result = 0;

        for (int i = 1; i < array.length - 1; i++) {
            int smaller = Math.min(M1[i], M2[i]);
            result += Math.max(0, (smaller - array[i]));

        }

        return result;

    }

    public static void main(String[] args) {
        MaxWatterTrappedI maxwater= new MaxWatterTrappedI();
        int result = maxwater.maxTrapped2(new int[]{5,3,1,4,6,2,3});
        System.out.println(result);
    }
}
