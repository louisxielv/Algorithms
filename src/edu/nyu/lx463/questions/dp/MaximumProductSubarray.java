package edu.nyu.lx463.questions.dp;

/**
 * Created by LyuXie on 7/18/17.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        // dp: base case : M[0] = nums[0]
        // induction rule: M[i] represents maxmum product subarray from 0th to ith(including ith element)
        // M[i] = M[i - 1] * nums[i]  if M[i - 1] * i > nums[i]
        // M[i] = nums[i]       else

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] M = new int[nums.length];
        M[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int number = nums[i];
            M[i] = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                M[i] = Math.max(number * M[j], M[i]);
                M[i] = Math.max(M[i], number);
                number *= nums[j];
            }

            result = Math.max(M[i], result);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray mp = new MaximumProductSubarray();
        System.out.println(mp.maxProduct(new int[]{2,-5,-2,-4,3}));
    }
}
