package bst;
import bst.BinarySearchTreeIterator.TreeNode;
/**
 * @Author: xck
 * @File: DeleteNodeinaBST
 * @Time: 20:56 2019/4/29
 */
public class DeleteNodeinaBST {



    private TreeNode findSuccessor(TreeNode root) {
        TreeNode cur = root.right;
        while (cur != null && cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
    public TreeNode deleteNode1(TreeNode root, int key) {
        // return null if root is null
        if (root == null) {
            return root;
        }

        // delete current node if root is the target node
        if (root.val == key) {
            // replace root with root->right if root->left is null
            if (root.left == null) {
                return root.right;
            }

            // replace root with root->left if root->right is null
            if (root.right == null) {
                return root.left;
            }

            // replace root with its successor if root has two children
            TreeNode p = findSuccessor(root);
            root.val = p.val;
            root.right = deleteNode1(root.right, p.val);
            return root;
        }
        if (root.val < key) {
            // find target in right subtree if root->val < key
            root.right = deleteNode1(root.right, key);
        } else {
            // find target in left subtree if root->val > key
            root.left = deleteNode1(root.left, key);
        }
        return root;
    }
}
