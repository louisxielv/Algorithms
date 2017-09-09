package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 5/19/17.
 */
public class LargestSubarraySum {
    public int largestSumSubarray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }


        int lastMax = array[0];
        int max = array[0];
        int start = 0;
        int solution_start;
        int solution_end;

        for (int i = 1; i < array.length; i++) {
            if (lastMax > 0) {
                lastMax = lastMax + array[i];
            }else {
                lastMax = array[i];
                start = i;
            }

            if (lastMax > max) {
                solution_end = i;
                solution_start = start;
            }
            max = Math.max(lastMax, max);
        }

        return max;
    }

    public static void main(String[] args) {
        LargestSubarraySum sm = new LargestSubarraySum();
        int result1 = sm.largestSumSubarray(new int[]{1,2,3,4});
        int result2 = sm.largestSumSubarray(new int[]{});
        int result3 = sm.largestSumSubarray(new int[]{-1,-2,-3,-4});
        int result4 = sm.largestSumSubarray(new int[]{1,-5,3,4,-8});
        int result5 = sm.largestSumSubarray(new int[]{-10,1,2,3});


        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);

    }
}
