package bst;

import bst.MaximumBinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xck
 * @File: ConstructBinarySearchTreefromPreorderTraversal
 * @Time: 17:21 2019/12/24
 */
public class ConstructBinarySearchTreefromPreorderTraversal {


    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return help(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode help(int[] preorder, int lower, int upper) {
        if (index >= preorder.length) {
            return null;
        }
        if (preorder[index] > upper || preorder[index] < lower) {
            return null;
        }
        int val = preorder[index];
        index++;
        TreeNode root = new TreeNode(val);
        root.left = help(preorder, lower, val);
        root.right = help(preorder, val, upper);
        return root;

    }
}
