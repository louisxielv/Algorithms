package edu.nyu.lx463.questions.binarySearch;

/**
 * Created by LyuXie on 3/31/17.
 */
public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;// find number of less or equal to mid in the array
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
