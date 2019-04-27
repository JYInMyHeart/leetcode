package bst;

import java.util.Stack;

/**
 * @Author: xck
 * @File: ValidateBinarySearchTree
 * @Time: 1:17 2019/4/28
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left();
            }
            root = stack.pop();
            if(pre != null && root.value() <= pre.value()) return false;
            pre = root;
            root = root.right();
        }
        return true;
    }
}
