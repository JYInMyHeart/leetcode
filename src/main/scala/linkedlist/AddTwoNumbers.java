package linkedlist;

/**
 * @Author: xck
 * @File: AddTwoNumbers
 * @Time: 10:14 2019/11/28
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ll1 = l1;
        ListNode ll2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        int last = 0;
        do {
            int s1 = ll1 == null ? 0 : ll1.x();
            int s2 = ll2 == null ? 0 : ll2.x();
            int sum = s1 + s2 + last;
            last = sum / 10;
            sum = sum % 10;
            node.next_$eq(new ListNode(sum));
            node = node.next();
            if (ll1 != null) ll1 = ll1.next();
            if (ll2 != null) ll2 = ll2.next();
        } while (ll1 != null || ll2 != null);

        if (last != 0)
            node.next_$eq(new ListNode(last));
        return dummy.next();
    }


}
