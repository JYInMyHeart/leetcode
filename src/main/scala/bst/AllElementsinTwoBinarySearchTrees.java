package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: xck
 * @File: AllElementsinTwoBinarySearchTrees
 * @Time: 18:41 2019/12/30
 */
public class AllElementsinTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        inorder(root1, q1);
        inorder(root2, q2);
        List<Integer> ans = new ArrayList<>();
        while (!q1.isEmpty() || !q2.isEmpty())
            if (q2.isEmpty())
                ans.add(q1.poll());
            else if (q1.isEmpty())
                ans.add(q2.poll());
            else
                ans.add(q1.peek() < q2.peek() ? q1.poll() : q2.poll());
        return ans;
    }
    private void inorder(TreeNode n, Queue<Integer> q) {
        if (n == null) return;
        inorder(n.left, q);
        q.offer(n.val);
        inorder(n.right, q);
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
