package edu.nyu.lx463.questions.heap;

import java.util.*;

/**
 * Created by LyuXie on 7/4/17.
 */
public class MaximumValuesOfSizeKSlidingWindows {
    private static class Element implements Comparable<Element>{
        int index;
        int value;
        Element(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Element e) {
            if (e.value == this.value) {
                return 0;
            }
            return this.value > e.value ? -1 : 1;
        }
    }
    public List<Integer> maxWindows(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Element> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new Element(i, array[i]));
        }

        result.add(maxHeap.peek().value);

        for (int i = k; i < array.length; i++){
            maxHeap.offer(new Element(i, array[i]));
            while (maxHeap.peek().index < i - k + 1) {
                maxHeap.poll();
            }

            result.add(maxHeap.peek().value);
        }

        return result;

    }

    public List<Integer> maxWindows2(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Element> deque = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            while (deque.peekLast() != null && deque.peekLast().value < array[i]) {
                deque.pollLast();
            }

            while (deque.peekFirst() != null && i > k - 1 && deque.peekFirst().index < i - k + 1) {
                deque.pollFirst();
            }

            deque.offerLast(new Element(i, array[i]));

            if (i >= k - 1) {
                result.add(deque.peekFirst().value);
            }


        }

        return result;

    }
    public static void main(String[] args) {
        MaximumValuesOfSizeKSlidingWindows maxs = new MaximumValuesOfSizeKSlidingWindows();
        List<Integer> result = maxs.maxWindows2(new int[]{1, 2, 3, 2, 4, 2, 1}, 3);
        for (int i : result){
            System.out.println(i);
        }
    }
}
