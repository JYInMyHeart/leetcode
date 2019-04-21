package bst;

/**
 * @Author: xck
 * @File: RangeSumBST
 * @Time: 23:10 2019/4/21
 */
public class RangeSumBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return sum;
        if (root.value() <= R && root.value() >= L) sum += root.value();
        rangeSumBST(root.left(), L, R);
        rangeSumBST(root.right(), L, R);
        return sum;
    }
}
