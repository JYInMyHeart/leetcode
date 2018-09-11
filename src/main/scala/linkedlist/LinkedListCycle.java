package linkedlist;

public class LinkedListCycle {
    //this solution use java call scala.so it's not a real accept solution.
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next() != null && slow != null){
            fast = fast.next().next();
            slow = slow.next();
            if(fast == slow) return true;
        }
        return false;
    }
}
