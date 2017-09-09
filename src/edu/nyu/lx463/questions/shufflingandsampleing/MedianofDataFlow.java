package edu.nyu.lx463.questions.shufflingandsampleing;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by LyuXie on 5/24/17.
 */
public class MedianofDataFlow {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianofDataFlow() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void read(int value) {
        if (maxHeap.size() == minHeap.size()) {
            if (maxHeap.size() == 0) {
                maxHeap.offer(value);
            }
            else if (value <= maxHeap.peek()) {
                maxHeap.offer(value);
            }
            else {
                minHeap.offer(value);
                maxHeap.offer(minHeap.poll());
            }
        }
        else {

            if (value <= maxHeap.peek()) {
                maxHeap.offer(value);
                minHeap.offer(maxHeap.poll());
            }
            else {
                minHeap.offer(value);
            }
        }
    }

    public Double median() {
        if (minHeap.size() == maxHeap.size()) {
            if (maxHeap.size() == 0) {
                return null;
            }
            return ((double)(minHeap.peek()) + (double)(maxHeap.peek())) / 2;
        }
        else {
            return (double)(maxHeap.peek());
        }

    }

    public static void main(String[] args) {
        MedianofDataFlow md = new MedianofDataFlow();
        md.read(1);
        md.read(2);
        double result = md.median();
        System.out.print(result);
    }
}
