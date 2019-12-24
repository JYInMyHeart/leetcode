package bst;

/**
 * @Author: xck
 * @File: MaximumBinaryTree
 * @Time: 12:01 2019/12/24
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = -1;
        for (int i = start; i <= end; i++) {
            max = Math.max(nums[i], max);
        }
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] == max) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, index - 1);
        root.right = helper(nums, index + 1, end);
        return root;
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
