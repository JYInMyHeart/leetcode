package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: xck
 * @File: BinarySearchTreeIterator
 * @Time: 1:51 2019/4/28
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> values = new Stack<>();
    public BinarySearchTreeIterator(TreeNode root) {
         putValue(root);
    }

    public void putValue(TreeNode root){
        while(root != null) {
            values.push(root);
            root = root.left;
        }

    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = values.pop();
        putValue(node.right);
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !values.isEmpty();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0,2);
        System.out.println(list);
    }
}
