package edu.nyu.lx463.questions.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by LyuXie on 4/1/17.
 */
public class IntersectionOfTwoArrays {
    public int[] intersection1(int[] nums1, int[] nums2) {
        // method1: using two HashSet
        // time complexity: O(n)
        // space complexity: O(n)

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            if (set1.contains(i)) {
                resultSet.add(i);
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int j : resultSet) {
            result[i++] = j;
        }


        return result;

    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        // method 2: using Binary Search
        // time complexity: O(nlogn)
        // space complexity: O(k) k is the size of result

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        for (int i : nums2) {
            if (binarySearch(nums1, i)) {
                set.add(i);
            }
        }

        int i = 0;
        int[] result = new int[set.size()];
        for (int j : set) {
            result[i++] = j;
        }

        return result;
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        // method 3 : sort both arrays and use tow pointer
        // time complexity: nlogn
        // space complexity: O(k) k is the reuslt number

        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        int[] result = new int[set.size()];
        int k = 0;

        for (int p : set) {
            result[k++] = p;
        }

        return result;
    }
    



    private boolean binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0, end = nums.length - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }


}

