package linkedlist;

/**
 * @Author: xck
 * @File: FlattenaMultilevelDoublyLinkedList
 * @Time: 10:43 2019/11/28
 */
public class FlattenaMultilevelDoublyLinkedList {
    //wrong answer
    //做错的原因在于，我想在一个迭代中完成两件事情
    //第一是对child结构的修正
    //第二是将child最后的那个节点的下一个节点设置为原来节点的next
    //但是这里有个问题，当我将child节点的结构修正的时候，没有修正child.child以及child.next
    //这导致结果结构还是错的。所以我只是修正了一层。如果把这个过程持续下去直到所有的child都为null
    //也可以达到目标，但是这样时间复杂度会变得很复杂
    //而正确的解法在于，在修正的过程中自然逼近child的最后的节点，不需要显式迭代到最后的那个节点。
    //同时又能够完成对child.next和child.child的修正。妙不可言
    public Node flattenError(Node head) {
        if(head == null) return head;
        Node node = head;
        while(node != null){
            Node next = node.next;
            if(node.child != null){
                Node f = flattenError(node.child);
                node.next = f;
                f.prev = node;
                Node tmp = node.next;
                Node prev = node;
                while(tmp != null){
                    tmp = tmp.next;
                    prev = prev.next;
                }
                prev.next = next;
                next.prev = prev;
                node.child = null;
            }

            node = next;
        }
        return head;
    }



    /*
    *
    * Input:
    *  1---2---3---4---5---6--NULL
    *          |
    *          7---8---9---10--NULL
    *              |
    *              11--12--NULL
    *
    * Output:
    * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
    *
    * 查看这个结构，类似于树结构，child类似于左节点，next类似于右节点。为了能让整棵树都压缩
    * 成一行，每次都对当前节点做如下操作：
    * 1.取当前节点curr和它的子节点child。
    * 2.将子节点设置为当前节点curr的右节点即使：curr.next= child;child.prev = curr;
    * 3.理论上讲对当前节点的操作应该结束了，但是还有个问题，child的结构还未修正。所以对child也要继续做如下操作：
    * Node temp = flatten(child,child.child)
    * 同时要保留下来当前节点之前的右节点 Node next = curr.next;这部分节点将作为child节点的右节点。
    * 同时由于修正了当前child，所以curr.child应该为null了。
    * 由于当我们将child节点提升为curr的右节点以后，child.next就会成为新的child.child,循环往复直到child.next == null
    * 此时就可以直接让child.next = next;next.prev = child。但是要注意当前next也是未经修正的所以还是要执行以下操作：
    * flatten(temp,next)，这样得到的结果就是最终结果。
    */

    public Node flatten(Node head) {
        if(head == null) return head;
        Node dummy = new Node(-1,null,head,null);

        helper(dummy,head);
        head.prev = null;
        return dummy.next;

    }





    public Node helper(Node prev, Node curr){
        if(curr == null) return prev;
        prev.next = curr;
        curr.prev = prev;

        Node next = curr.next;
        Node tail = helper(curr,curr.child);
        curr.child = null;
        return helper(tail,next);
    }
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};