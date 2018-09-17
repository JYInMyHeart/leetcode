package bst;


import java.util.ArrayList;
import java.util.stream.Stream;

public class MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        return 1 + root.children.stream().map(this::maxDepth).max(Integer::compareTo).orElse(0);

    }
}
