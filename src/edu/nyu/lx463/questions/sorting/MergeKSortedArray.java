package edu.nyu.lx463.questions.sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by LyuXie on 6/6/17.
 */
public class MergeKSortedArray {
    static class Entry{
        int x;
        int y;
        int value;
        Entry(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public int[] merge(int[][] arrayOfArrays) {
        int length= 0;
        PriorityQueue<Entry> minHeap = new PriorityQueue<>(11, new Comparator<Entry>() {
            public int compare(Entry a, Entry b) {
                return a.value < b.value ? -1 : 1;
            }
        });

        for (int i = 0; i < arrayOfArrays.length; i++) {
            length += arrayOfArrays[i].length;
            if (arrayOfArrays[i].length > 0) {
                minHeap.offer(new Entry(i, 0, arrayOfArrays[i][0]));
            }

        }

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            Entry temp = minHeap.poll();
            result[i] = temp.value;
            if (temp.y + 1 < arrayOfArrays[temp.x].length) {
                minHeap.offer(new Entry(temp.x, temp.y + 1, arrayOfArrays[temp.x][temp.y + 1]));
            }
        }

        return result;

    }


    public static void main(String[] args) {
        MergeKSortedArray mk = new MergeKSortedArray();

        int[] result = mk.merge(new int[][]{{},{1,5,7},{4},{2,3,5,11},{2,4,4,6,8}});
    }
}
