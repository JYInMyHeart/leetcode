package test;


public class Test {
    public static void main(String[] args) {
        TreeNode m = new TreeNode(1);
        TreeNode t = m;
         t = t.right   = new TreeNode(2);
//        t  =t.right;
        System.out.println(t);
    }


}
