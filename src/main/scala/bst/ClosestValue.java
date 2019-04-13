package bst;

import sun.reflect.generics.tree.Tree;

/**
 * @Author: xck
 * @File: ClosestValue
 * @Time: 17:15 2019/4/13
 */
public class ClosestValue {
    public int closestValue(TreeNode root, double target) {
        int ret = root.value();
        while (root != null) {
            if (Math.abs(target - root.value()) < Math.abs(target - ret)) {
                ret = root.value();
            }
            root = root.value() > target ? root.left() : root.right();
        }
        return ret;
    }

    public int helper(TreeNode root, double target) {
        int a = root.value();
        TreeNode kid = target < a ? root.left() : root.right();
        if (kid == null) return a;
        int b = helper(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }


}
