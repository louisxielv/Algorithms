package edu.nyu.lx463.questions.LinkedList;

/**
 * Created by LyuXie on 4/9/17.
 */
public class RemoveNthNodeFromEnd {
    public static ListNode removeNthNodeFromEnd(ListNode head, int n){
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slower = dummy;
        ListNode faster = dummy;


        // create the slide window
        while (n > 0) {
            faster = faster.next;
            n--;
        }

        // find the node before the target
        while (faster.next != null) {
            faster = faster.next;
            slower = slower.next;
        }


        // perform the delete
        slower.next = slower.next.next;
        return dummy.next;
    }

}
