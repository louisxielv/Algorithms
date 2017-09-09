package edu.nyu.lx463.questions.LinkedList;

/**
 * Created by LyuXie on 5/13/17.
 */
public class AddTwoNumbers{

        public ListNode addTwoNumber(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            int carryOn = 0; // the extra 1 given by adding last digits(carryOn)
            int sum = 0;
            while (l1 != null || l2 != null) {

                if (l1 != null && l2 != null) {
                    sum = l1.value + l2.value + carryOn;
                }
                if (l1 == null && l2 != null) {
                    sum = l2.value + carryOn;
                    l2 = l2.next;
                }
                if (l1 != null && l2 == null) {
                    sum = l1.value + carryOn;
                    l1 = l1.next;
                }
                if (sum < 10) {
                    curr.next = new ListNode(sum);
                    carryOn = 0;
                } else {
                    curr.next = new ListNode(sum % 10);
                    carryOn = 1;
                }
            }
            return dummy.next;
        }

        static class ListNode {
            int value;
            ListNode next;

            public ListNode(int value) {
                this.value = value;
            }
        }



}
