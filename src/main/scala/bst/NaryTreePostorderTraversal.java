package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {
    //recursive
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root,ans);
        return ans;
    }

    public void helper(Node root,List<Integer> ans){
        if(root == null) return;
        for(Node n:root.children){
            helper(n,ans);
        }
        ans.add(root.val);
    }



    //iterative
    public List<Integer> postorder1(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(root == null) return ans;
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            for(Node n:curr.children){
                stack.push(n);
            }
            ans.add(0,curr.val);
        }
        return ans;
    }
}
