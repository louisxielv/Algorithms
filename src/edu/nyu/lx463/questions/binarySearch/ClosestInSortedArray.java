package edu.nyu.lx463.questions.binarySearch;

/**
 * Created by LyuXie on 3/26/17.
 */
public class ClosestInSortedArray {
    public int closest(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0, end = array.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start +(end - start) / 2;
            if (array[mid] == target) {
                return mid;
            }
            else if (array[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        System.out.print(start);
        System.out.print(end);
        if (Math.abs(array[start] - target) < Math.abs(array[end] - target)) {
            return start;
        }
        else {
            return end;
        }
    }
}
