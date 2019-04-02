package linkedlist;

/**
 * @Author: xck
 * @File: RotateRight
 * @Time: 12:41 2019/4/2
 */
public class RotateRight {
    public static ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode tmp = head;
        while(tmp != null){
            n++;
            tmp = tmp.next();
        }
        tmp = head;
        for (int i = 0; i < n - k; i++) {
            tmp = tmp.next();
        }

        ListNode next = tmp.next();
        tmp.next_$eq(null);
        ListNode node = next;
        while(next != null && next.next() != null){
            next = next.next();
        }
        next.next_$eq(head);
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next_$eq(head1);
        head1.next_$eq(head2);
        head2.next_$eq(head3);
        head3.next_$eq(head4);
        rotateRight(head,2);
    }
}
