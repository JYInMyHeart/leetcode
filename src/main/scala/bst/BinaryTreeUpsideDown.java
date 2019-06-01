package bst;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: xck
 * @File: BinaryTreeUpsideDown
 * @Time: 12:36 2019/6/1
 */
public class BinaryTreeUpsideDown {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static TreeNode upsideDownBinaryTree(TreeNode root) {
       if(root == null || root.left == null) return root;
       TreeNode newRoot = upsideDownBinaryTree(root.left);
       root.left.left = root.right;
       root.left.right = root;
       root.left = null;
       root.right = null;
      return newRoot;
    }

    public  TreeNode upsideDownBinaryTree1(TreeNode root) {
        TreeNode curr = root;
        TreeNode temp = null;
        TreeNode prev = null;
        TreeNode next = null;
        while(curr != null){
          next = curr.left;
          curr.left = temp;
            temp = curr.right;
          curr.right = prev;
            prev = curr;
          curr = next;
        }
        return prev;
    }



    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        upsideDownBinaryTree(n1);
    }
}
