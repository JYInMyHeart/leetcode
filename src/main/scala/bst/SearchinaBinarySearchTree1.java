package bst;


import java.util.Stack;

/**
 * @Author: xck
 * @File: SearchinaBinarySearchTree1
 * @Time: 20:24 2019/4/29
 */
public class SearchinaBinarySearchTree1 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.value() == val) return root;
        else if (root.value() > val)
            return searchBST(root.left(), val);
        else
            return searchBST(root.right(), val);

    }

    public BinarySearchTreeIterator.TreeNode searchBST(BinarySearchTreeIterator.TreeNode root, int val) {
        if(root == null) return null;
        Stack<BinarySearchTreeIterator.TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(val < root.val) return null;
            else if(root.val == val) return root;
            else {
                root = root.right;
            }
        }
        return null;
    }
}
