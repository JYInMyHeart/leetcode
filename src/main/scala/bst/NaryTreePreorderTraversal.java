package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {
    //recursive
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root,ans);
        return ans;
    }
    public void helper(Node root, List<Integer> ans){
        if(root == null) return;
        ans.add(root.val);
        for(Node n:root.children){
            helper(n,ans);
        }
    }

    //iterative
    public List<Integer> postorder1(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(root == null) return ans;
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            ans.add(curr.val);
            for(int i = curr.children.size() - 1;i >= 0;i--){
                stack.push(curr.children.get(i));
            }
        }
        return ans;
    }
}
