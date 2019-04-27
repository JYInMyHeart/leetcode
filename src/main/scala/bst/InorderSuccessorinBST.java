package bst;

import java.util.Stack;

/**
 * @Author: xck
 * @File: InorderSuccessorinBST
 * @Time: 1:33 2019/4/28
 */
public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left();
            }
            root = stack.pop();
            if (pre != null && pre.value() == p.value()) return root;
            pre = root;
            root = root.right();
        }
        return null;
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.value() <= p.value()) {
            return inorderSuccessor1(root.right(), p);
        } else {
            TreeNode left = inorderSuccessor1(root.left(), p);
            return (left != null) ? left : root;
        }
    }


}
