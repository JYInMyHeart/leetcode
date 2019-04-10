package bst;

import sun.reflect.generics.tree.Tree;

/**
 * @Author: xck
 * @File: LowestCommonAncestorofaBinaryTree
 * @Time: 11:41 2019/4/10
 */
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.value() == p.value() || root.value() == q.value()) return root;
            TreeNode left = lowestCommonAncestor(root.left(), p, q);
            TreeNode right = lowestCommonAncestor(root.right(), p, q);
        return (left == null) ? right : ((right == null) ? left : root);
    }
}
