package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: xck
 * @File: BinaryTreeRightSideView
 * @Time: 10:54 2019/5/28
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(i == size - 1)
                    result.add(node.value());
                if(node.left() != null)
                    queue.offer(node.left());
                if(node.right() != null)
                    queue.offer(node.right());
            }
        }
        return result;
    }
}
