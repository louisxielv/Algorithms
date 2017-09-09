package edu.nyu.lx463.questions.LinkedList;

/**
 * Created by LyuXie on 4/7/17.
 */
public class MergeKSortedLists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

        public static ListNode mergeKSortedLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            return mergeKSortedLists(lists, 0, lists.length - 1);
        }

        private static ListNode mergeKSortedLists(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start];
            }

            int mid = start + (end - start) / 2;

            ListNode firstHalf = mergeKSortedLists(lists, start, mid);
            ListNode lastHalf = mergeKSortedLists(lists, mid + 1, end);

            return merge(firstHalf, lastHalf);

        }


        private static ListNode merge(ListNode head1, ListNode head2) {
            if (head1 == null) {
                return head2;
            }
            if (head2 == null) {
                return head1;
            }

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (head1 != null && head2 != null) {
                if (head1.val <= head2.val) {
                    tail.next = head1;
                    head1 = head1.next;
                }
                else {
                    tail.next = head2;
                    head2 = head2.next;
                }

                tail = tail.next;
            }

            if (head1 != null) {
                tail.next = head1;
            }
            if (head2 != null) {
                tail.next = head2;
            }

            return dummy.next;
        }

}
