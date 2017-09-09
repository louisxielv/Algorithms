package edu.nyu.lx463.questions.LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by LyuXie on 4/9/17.
 */
public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        while (l1 != null) {
            stack1.offerLast(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.offerLast(l2.val);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = null;

        int addOn = 0;
        int digit = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int total = 0;
            if (!stack1.isEmpty()) {
                total += stack1.pollLast();
            }
            if (!stack2.isEmpty()) {
                total += stack2.pollLast();
            }

            total += addOn;
            digit = total % 10;
            addOn = total / 10;
            ListNode newNode = new ListNode(digit);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        if (addOn != 0) {
            ListNode newNode = new ListNode(addOn);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        return dummy.next;
    }
}

