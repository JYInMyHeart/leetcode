package bst;

import java.util.Stack;

/**
 * @Author: xck
 * @File: BinarySearchTreetoGreaterSumTree
 * @Time: 18:43 2019/12/10
 */
public class BinarySearchTreetoGreaterSumTree {

    public TreeNode bstToGst(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;

        TreeNode tmp = root;
        int sum = 0;
        while (tmp != null || !stack.isEmpty()) {
            helper(tmp, stack);
            tmp = stack.pop();
            sum += tmp.val;
            tmp.val = sum;
            tmp = tmp.left;
        }
        return root;
    }

    public void helper(TreeNode n, Stack<TreeNode> stack) {
        while (n != null) {
            stack.push(n);
            n = n.right;
        }
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
