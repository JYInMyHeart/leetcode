package bst;

import java.util.List;

public class MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        return 1 + root.children.stream().map(this::maxDepth).max(Integer::compareTo).orElse(0);
    }



    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
