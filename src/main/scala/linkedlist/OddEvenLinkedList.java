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

    /*
    *
    *   if(head == null) return head;
        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenHead = even;
        while ( even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    *
    *
    *
    *
    *
    *
    * */

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null  && even.next !=null && odd != null){
            even.next = even.next.next;
            odd.next = odd.next.next;
            even = even.next;
            odd = odd.next;
        }
        odd.next = evenHead;
        return head;
    }


}
