package edu.nyu.lx463.questions.binarySearch;

/**
 * Created by LyuXie on 3/27/17.
 */
public class ClassicBinarySearch {
    public static int binarySearch(int[] array, int target) {
        // Write your solution here.
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        int mid;

        while (start <= end) { // 用等于的原因： 当只有一个元素的时候， 需要进入while 循环 e.g. {5}
            mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            }
            else if (array[mid] < target) {
                start = mid + 1; // 加1的原因：避免死循环， 当只有一个元素时， e.g. {5} target = 7
            }
            else {
                end = mid - 1; // 同上
            }
        }
        return -1;
    }
}
