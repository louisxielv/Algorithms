package edu.nyu.lx463.questions.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by LyuXie on 4/14/17.
 */
public class KSmallestInUnsortedArray {
    public static int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length - 1, k);
        int[] result = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        Arrays.sort(result);
        return result[0];
    }

    private static void quickSelect(int[] nums, int left, int right, int k) {

        int pivotIndex = partition(nums, left, right);
        if (pivotIndex < nums.length - k) {
            left = pivotIndex + 1;
        } else if (pivotIndex > nums.length - k) {
            right = pivotIndex - 1;
        } else {
            return;
        }

        quickSelect(nums, left, right, k);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivotPos = left + (int) (Math.random() * (right - left + 1));
        swap(nums, right, pivotPos);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (nums[leftBound] <= nums[right]) {
                leftBound++;
            } else {
                swap(nums, leftBound, rightBound--);
            }
        }

        swap(nums, leftBound, right);
        return leftBound;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(KSmallestInUnsortedArray.findKthLargest(new int[]{2, 1}, 2));
    }
}

