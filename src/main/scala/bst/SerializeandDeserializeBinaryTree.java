package bst;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: xck
 * @File: SerializeandDeserializeBinaryTree
 * @Time: 15:37 2019/4/10
 */
public class SerializeandDeserializeBinaryTree {
    private final static String seprator = "#";
    private final static String comma = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        treeToString(root, sb);
        return sb.toString();
    }


    private void treeToString(TreeNode root, StringBuffer sb) {

        if (root == null) {
            sb.append(seprator).append(comma);

        } else {
            sb.append(root.value()).append(comma);
            treeToString(root.left(), sb);
            treeToString(root.right(), sb);
        }


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.<String>asList(data.split(comma)));
        return stringToTree(nodes);
    }

    private TreeNode stringToTree(Deque<String> treeStr) {
        String val = treeStr.remove();
        if (val.endsWith(seprator)) {
            return null;
        } else {
            int value = Integer.valueOf(val);
            TreeNode root = new TreeNode(value);
            root.left_$eq(stringToTree(treeStr));
            root.right_$eq(stringToTree(treeStr));
            return root;
        }
    }
}
