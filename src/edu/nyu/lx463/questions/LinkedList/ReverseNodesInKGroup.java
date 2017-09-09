package edu.nyu.lx463.questions.LinkedList;

/**
 * Created by LyuXie on 4/7/17.
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        int size = 1;
        ListNode curt = head;
        while (curt.next != null && size != k) {
            curt = curt.next;
            ++size;
        }

        if (size == k) {
            //int size = k;
            ListNode oldHead = head;
            ListNode prev = null;
            ListNode now = head;
            while (size > 0) {
                ListNode nextNode = now.next;
                now.next = prev;
                prev = now;
                now = nextNode;
                size --;
            }

            ListNode sub = reverseKGroup1(now, k);
            oldHead.next = sub;
            return prev;
        }

        return head;

    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, newHead = dummy, curt;
        int count;
        while (true) {
            count = k;
            while (count > 0 && newHead != null) {
                newHead = newHead.next;
                count --;
            }

            if (newHead == null) {
                break;
            }

            head = prev.next;
            while (prev.next != newHead) {
                curt = prev.next;
                prev.next = curt.next;
                curt.next = newHead.next;
                newHead.next = curt;
            }

            prev = head;
            newHead = head;

        }
        return dummy.next;
    }
}
