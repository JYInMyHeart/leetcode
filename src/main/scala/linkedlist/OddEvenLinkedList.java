package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xck
 * @File: OddEvenLinkedList
 * @Time: 23:42 2019/5/21
 */
public class OddEvenLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode even = head;
        ListNode odd = head.next;
        ListNode oddhead = odd;
        while (odd != null  && odd.next !=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        even.next = oddhead;
        return head;
    }
}
