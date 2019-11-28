package linkedlist;

/**
 * @Author: xck
 * @File: InsertintoaCyclicSortedList
 * @Time: 13:36 2019/11/28
 */
public class InsertintoaCyclicSortedList {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node res = new Node(insertVal);
            res.next = res;
            return res;
        }
        Node prev = head;
        Node node = prev.next;
        while(node != head){
            if(prev.val  <= node.val){
                if(insertVal >= prev.val && insertVal <= node.val){
                    prev.next = new Node(insertVal,node);
                    return head;
                }
            }
            else {
                if(insertVal >= prev.val || insertVal <= node.val){
                    prev.next = new Node(insertVal,node);
                    return head;
                }
            }

            prev = prev.next;
            node = node.next;
        }
        prev.next = new Node(insertVal,node);
        return head;
    }
    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
}
