package edu.nyu.lx463.questions.LinkedList;

/**
 * Created by LyuXie on 4/7/17.
 */
public class Main {
    public static void main(String[] args) {
//        test of MergeKSortedLists
//        ListNode[] lists = new ListNode[5];
//        ListNode head1 = new ListNode(1);
//        ListNode head2 = new ListNode(2);
//        ListNode head3 = new ListNode(3);
//        ListNode head4 = new ListNode(4);
//        ListNode head5 = new ListNode(5);
//        ListNode head6 = new ListNode(6);
//        ListNode head7 = new ListNode(7);
//        ListNode head8 = new ListNode(8);
//        ListNode head9 = new ListNode(9);
//        ListNode head10 = new ListNode(10);
//        ListNode head11 = new ListNode(11);
//
//        head1.next = head2;
//
//        head3.next = head4;
//
//        head5.next = head6;
//        head6.next = head7;
//
//        head8.next = head9;
//
//        head10.next = head11;
//
//        lists[0] = head1;
//        lists[1] = head3;
//        lists[2] = head5;
//        lists[3] = head8;
//        lists[4] = head10;
//
//        ListNode result = MergeKSortedLists.mergeKSortedLists(lists);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }


//        test of ReverseNodesInKGroup


        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);
        ListNode head7 = new ListNode(7);
        ListNode head8 = new ListNode(8);
        ListNode head9 = new ListNode(9);
        ListNode head10 = new ListNode(10);
        ListNode head11 = new ListNode(11);
        ListNode head12 = new ListNode(12);

        head1.next= head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = head7;
        head7.next = head8;
        head8.next = head9;
        head9.next = head10;
        head10.next = head11;
        head11.next = null;

        head12.next = null;

        ListNode result = OddEvenLinkedList.oddEvenLinkedList(head1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
