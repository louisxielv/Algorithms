package edu.nyu.lx463.questions.datastructureimplementation;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by LyuXie on 8/19/17.
 */
public class MinQueue {
    static class Pair{
        int value;
        int min;
        Pair(int value, int min){
            this.value = value;
            this.min = min;
        }
    }

    private static final Deque<Pair> stack1 = new LinkedList<>();
    private static final Deque<Pair> stack2 = new LinkedList<>();

    public void offer(int x) {
        if(stack1.isEmpty()) {
            stack1.offerFirst(new Pair(x, x));
        }else {
            stack1.offerFirst(new Pair(x, Math.min(stack1.peekFirst().min, x)));
        }
    }

    public int poll() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }else if (stack1.isEmpty()) {
            return stack2.pollFirst().value;
        }else {
            while (!stack1.isEmpty()) {
                Pair temp = stack1.poll();
                if (stack2.isEmpty()) {
                    stack2.offer(new Pair(temp.value, temp.value));
                }

                stack2.offer(new Pair(temp.value, Math.min(stack2.peekFirst().min, temp.value)));
            }

            return stack2.pollFirst().value;
        }
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        if (!stack1.isEmpty()) {
            min = Math.min(min, stack1.peekFirst().min);
        }
        if (!stack2.isEmpty()) {
            min = Math.min(min, stack2.peekFirst().min);
        }

        return min;
    }



}
