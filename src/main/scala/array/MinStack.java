package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xck
 * @File: MinStack
 * @Time: 23:16 2019/4/23
 */
public class MinStack {
    List<Integer> list = new ArrayList<>();
    /** initialize your data structure here. */
    public MinStack() {

    }



    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        int a = list.get(list.size() - 1);
        list.remove(list.size() - 1);

    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i:list){
            min = Math.min(i,min);
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();  // --> Returns -3.
        minStack.pop();//
        minStack.top();     // --> Returns 0.
        minStack.getMin();  // --> Returns -2.
    }
}
