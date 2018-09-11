package linkedlist;

public class LinkedListCycleII {
    //this solution use java call scala.so it's not a real accept solution.
    public ListNode hasCycle(ListNode head) {
        //use two pointers twice to solve this problem.
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next() != null && slow != null){
            fast = fast.next().next();
            slow = slow.next();
            if(fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next();
                    slow2 = slow2.next();
                }
                return slow;
            }
        }
        return null;
    }
}
