package edu.nyu.lx463.questions.binarySearch;

/**
 * Created by LyuXie on 3/30/17.
 */
public class MedianOfTowSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (findKthElementSortedArrays(nums1, 0, nums2, 0, len / 2) + findKthElementSortedArrays(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
        else {
            return findKthElementSortedArrays(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }

    private int findKthElementSortedArrays(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }

        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int nums1_key = start1 + k / 2 - 1< nums1.length? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int nums2_key = start2 + k / 2 - 1< nums2.length? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;

        if (nums1_key < nums2_key) {
            return findKthElementSortedArrays(nums1, start1+ k / 2, nums2, start2 , k - k / 2);
        }
        else {
            return findKthElementSortedArrays(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }


}
