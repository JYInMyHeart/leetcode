package bst;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: xck
 * @File: TwoSumBSTs
 * @Time: 16:19 2019/12/10
 */


public class TwoSumBSTs {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val + root2.val > target) {
            return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
        } else if (root1.val + root2.val < target) {
            return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);
        } else {
            return true;
        }
    }

    public boolean twoSumBSTs1(TreeNode root1, TreeNode root2, int target) {

        if (root1 == null || root2 == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        inOrder(root1,set);
        return inOrder1(root2,set,target);
    }

    public void inOrder(TreeNode n,Set<Integer> set){
        Stack<TreeNode> stack = new Stack<>();


        while(n != null || !stack.isEmpty()){
            helper(n,stack);
            n = stack.pop();
            set.add(n.val);
            n = n.right;
        }
    }

    public boolean inOrder1(TreeNode n,Set<Integer> set,int target){
        Stack<TreeNode> stack = new Stack<>();

        while(n != null || !stack.isEmpty()){
            helper(n,stack);
            n = stack.pop();
            if(set.contains(target - n.val)) return true;
            n = n.right;
        }
        return false;
    }

    public void helper(TreeNode root,Stack<TreeNode> stack){
        while(root != null){
            stack.push(root);
            root = root.left;
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
