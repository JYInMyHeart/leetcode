package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xck
 * @File: FindDuplicateSubtrees
 * @Time: 13:31 2019/12/3
 */
public class FindDuplicateSubtrees {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        helper(root);
        return list;

    }

    public String helper(TreeNode tree) {
        if (tree == null) return "#";
        String s = tree.val + "," + helper(tree.left) + "," + helper(tree.right);
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2)
            list.add(tree);
        return s;
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
