package linkedlist;

/**
 * @Author: xck
 * @File: IntersectionofTwoLinkedLists
 * @Time: 0:10 2019/5/3
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next();
            b = b == null? headA : b.next();
        }

        return a;
    }
}
