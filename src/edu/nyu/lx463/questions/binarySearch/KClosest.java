package edu.nyu.lx463.questions.binarySearch;

/**
 * Created by LyuXie on 3/26/17.
 */
public class KClosest {

    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        if (array.length == 0) {
            return array;
        }
        if (k == 0) {
            return new int[]{};
        }

        int[] result = new int[k];
        int closest = closest(array, target);
        result[0] = array[closest];
        int left = closest - 1;
        int right = closest + 1;


        for (int i = 1; i < k; i++) {
            if (right >= array.length || left >= 0 && Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
                result[i] = array[left--];
            }else {
                result[i] = array[right++];
            }
        }

        return result;
    }

    private int closest(int[] array, int target) {
        int start = 0, end = array.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            }
            else if (array[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }

        if (Math.abs(array[end] - target) < Math.abs(array[start] - target)) {
            return end;
        }else {
            return start;
        }
    }

    public static void main(String[] args) {
        KClosest kc = new KClosest();
        int [] result = kc.kClosest(new int[]{2, 2}, 0, 0);
    }


}
