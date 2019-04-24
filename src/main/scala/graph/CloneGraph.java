package graph;

import java.util.*;

/**
 * @Author: xck
 * @File: CloneGraph
 * @Time: 10:44 2019/4/24
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node node, Map<Integer, Node> map) {
        if (node == null) return null;
        List<Node> neighbors = new ArrayList<>();
        if (map.containsKey(node.val)) return map.get(node.val);
        Node root = new Node(node.val, neighbors);
        if (node.neighbors == null) return root;
        map.put(node.val, root);
        for (int i = 0; i < node.neighbors.size(); i++) {
            neighbors.add(dfs(node.neighbors.get(i), map));
        }
        return root;
    }


    public Node cloneGraph1(Node node) {
        Stack<Node> stack = new Stack<>();
        if (node == null) return null;
        Node head = new Node(node.val, new ArrayList<>());
        stack.add(node);
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, head);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            for (Node nn : n.neighbors) {
                if (!map.containsKey(nn.val)) {
                    Node root = new Node(nn.val, new ArrayList<>());
                    map.put(nn.val, root);
                    stack.push(nn);
                    map.get(n.val).neighbors.add(root);
                } else
                    map.get(n.val).neighbors.add(map.get(nn.val));
            }
        }
        return head;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};