package array;

/**
 * @Author: xck
 * @File: ReverseNodesinkGroup
 * @Time: 15:02 2019/12/12
 */
public class ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            count++;
            cur = cur.next;
        }

        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
            }
            head = cur;
        }
        return head;
    }

    public ListNode reverse(ListNode start, ListNode end){
      ListNode cur = start.next;
      ListNode prev = start;
      ListNode first = cur;
      while(cur != end){
          ListNode next = cur.next;
          cur.next = prev;
          prev = cur;
          cur = next;
      }
      start.next = prev;
      first.next = cur;
      return prev;
    }


    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
