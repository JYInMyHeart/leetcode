package bst;

/**
 * @Author: xck
 * @File: BinaryTreePruning
 * @Time: 0:57 2020/1/6
 */

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (isZero(root)) {
            return null;
        }
        if (isZero(root.left)) {
            root.left = null;
        } else {
            pruneTree(root.left);
        }
        if (isZero(root.right)) {
            root.right = null;
        } else {
            pruneTree(root.right);
        }
        return root;
    }

    public boolean isZero(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val != 0) {
            return false;
        }
        return isZero(root.left) && isZero(root.right);
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
