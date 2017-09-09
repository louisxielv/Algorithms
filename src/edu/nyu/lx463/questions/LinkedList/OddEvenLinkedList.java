package edu.nyu.lx463.questions.LinkedList;

/**
 * Created by LyuXie on 4/9/17.
 */
public class OddEvenLinkedList {
    public static ListNode oddEvenLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = head.next, oddCurr = head, evenCurr = head.next;
        while (oddCurr.next != null && evenCurr.next != null) {
            oddCurr.next = oddCurr.next.next;
            evenCurr.next = evenCurr.next.next;
            oddCurr = oddCurr.next;
            evenCurr = evenCurr.next;
        }

        oddCurr.next = evenHead;
        return head;

    }

}
