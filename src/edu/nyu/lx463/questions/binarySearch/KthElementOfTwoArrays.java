package edu.nyu.lx463.questions.binarySearch;

import edu.nyu.lx463.questions.BFS2.KthCloestTo000;

/**
 * Created by LyuXie on 7/4/17.
 */
public class KthElementOfTwoArrays {
    public int kth(int[] a, int[] b, int k) {
        return findKth(a, 0, b, 0, k);

    }

    private int findKth(int[] a, int aLeft, int[] b, int bLeft, int k) {
        if (aLeft >= a.length) {
            return b[bLeft + k - 1];
        }
        if (bLeft >= b.length) {
            return a[aLeft + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aLeft], b[bLeft]);
        }

        int aLeft_temp = aLeft + k / 2 - 1 >= a.length ? Integer.MAX_VALUE : a[aLeft + k / 2 - 1];
        int bLeft_temp = bLeft + k / 2 - 1 >= b.length ? Integer.MAX_VALUE : b[bLeft + k / 2 - 1];

        if (aLeft_temp < bLeft_temp) {
            return findKth(a, aLeft + k / 2, b, bLeft, k - k / 2);
        }
        else if (aLeft_temp > bLeft_temp) {
            return findKth(a, aLeft, b, bLeft + k / 2, k - k / 2);
        }else {
            return aLeft_temp;
        }
    }

    public static void main(String[] args) {
        KthElementOfTwoArrays kth = new KthElementOfTwoArrays();
        System.out.print(kth.kth(new int[]{1, 4, 6}, new int[]{2, 3}, 3));
    }
}
