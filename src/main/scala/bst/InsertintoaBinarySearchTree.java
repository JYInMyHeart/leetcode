package bst;
import bst.BinarySearchTreeIterator.TreeNode;

import java.util.Stack;

/**
 * @Author: xck
 * @File: InsertintoaBinarySearchTree
 * @Time: 20:35 2019/4/29
 */
public class InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        TreeNode pre = null;
        while(head != null){
            if(head.val > val){
                pre = head;
                head = head.left;
            }
            else{
                pre = head;
                head = head.right;
            }
        }
        if(val > pre.val) pre.right = new TreeNode(val);
        else pre.left = new TreeNode(val);
        return root;
    }
}
