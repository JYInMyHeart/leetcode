package array;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: xck
 * @File: PopulatingNextRightPointersInEachNode
 * @Time: 11:19 2019/4/10
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                list.add(queue.poll());
            }
            for (int i = 0; i < size - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            list.get(size - 1).next = null;
        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
