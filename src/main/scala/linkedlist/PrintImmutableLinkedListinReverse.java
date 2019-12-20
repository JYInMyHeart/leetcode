package linkedlist;

import java.util.Stack;

/**
 * @Author: xck
 * @File: PrintImmutableLinkedListinReverse
 * @Time: 11:58 2019/12/20
 */
public class PrintImmutableLinkedListinReverse {
    interface ImmutableListNode {
     public void printValue(); // print the value of this node.
     public ImmutableListNode getNext(); // return the next node.
 };
    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.getNext();
        }

        while(!stack.isEmpty()){
            ImmutableListNode node = stack.pop();
            node.printValue();
        }
    }
}
