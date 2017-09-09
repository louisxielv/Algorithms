package edu.nyu.lx463.questions.binarySearch;

/**
 * Created by LyuXie on 3/30/17.
 */
public class FindMinRotatedArray {
    /*
        find the first positon less or equal to nums[end]

        can't use nums[start] as the target(first position less than nums[start])
        becasue if {1,2,3,4,5}
        no condition can be satisfied
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int standard = nums[nums.length - 1];
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > standard) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (nums[start] <= standard) {
            return nums[start];
        }
        else {
            return nums[end];
        }
    }
}
