package linkedlist;

/**
 * @Author: xck
 * @File: PalindromeLinkedList
 * @Time: 0:21 2019/5/22
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode test = reverse(slow);
        while(test != null && head != null){
            if(test.val != head.val) return false;
            test = test.next;
            head = head.next;
        }
        return true;
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverse(ListNode root){
        if(root == null) return root;
        ListNode head = null;
        while(root != null){
            ListNode next = root.next;
            root.next = head;
            head = root;
            root = next;
        }
        return head;
    }
}
