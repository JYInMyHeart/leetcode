package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: xck
 * @File: DinnerPlates
 * @Time: 11:24 2020/1/8
 */
public class DinnerPlates {

    private List<int[]> stackList;
    private int stackSize;

    public DinnerPlates(int capacity) {
        stackList = new LinkedList<>();
        stackSize = capacity;
        stackList.add(new int[stackSize]);
    }

    public static void main(String[] args) {
        DinnerPlates d = new DinnerPlates(2);
        d.push(1);
        d.push(2);
        d.push(3);
        d.push(4);
        d.push(5);
        System.out.println(d.popAtStack(0));
        d.push(20);
        d.push(21);
        System.out.println(d.popAtStack(0));
        System.out.println(d.popAtStack(2));
        System.out.println(d.pop());
        System.out.println(d.pop());
        System.out.println(d.pop());
        System.out.println(d.pop());
        System.out.println(d.pop());

    }

    public void push(int val) {
        boolean added = false;
        loop:
        for (int[] stack : stackList) {
            {
                for (int i = 0; i < stack.length; i++) {
                    if (stack[i] == 0) {
                        stack[i] = val;
                        added = true;
                        break loop;
                    }
                }
            }
        }
        if (!added) {
            int[] stack = new int[stackSize];
            stack[0] = val;
            stackList.add(stack);
        }
    }

    public int pop() {
        for (int i = stackList.size() - 1; i >= 0; i--) {
            Integer temp = getInteger(i);
            if (temp != null)
                return temp;
        }
        return -1;
    }

    public int popAtStack(int index) {
        if (index >= stackList.size()) {
            return -1;
        }
        Integer temp = getInteger(index);
        if (temp != null)
            return temp;
        return -1;
    }

    private Integer getInteger(int index) {
        int[] stack = stackList.get(index);
        for (int i = stack.length - 1; i >= 0; i--) {
            if (stack[i] != 0) {
                int temp = stack[i];
                stack[i] = 0;
                return temp;
            }
        }
        return null;
    }
}


class Soultion{
    Map<Integer, Stack<Integer>> map;
    int cap;
    int curr;
    int last;
    int count;

    public Soultion(int capacity) {
        cap = capacity;
        curr = 0;
        last = 0;
        count = 0;
        map = new HashMap<>();
        map.put(curr, new Stack<>());
    }

    public void push(int val) {
        while(map.containsKey(curr) && map.get(curr).size()==cap){
            curr++;
        }
        if(!map.containsKey(curr)){
            map.put(curr, new Stack<>());
        }
        map.get(curr).push(val);
        last = Math.max(last, curr);
        count++;
    }

    public int pop() {
        if(count==0) return -1;
        while(last>=0 && map.get(last).isEmpty()){
            last--;
        }
        count--;
        curr=Math.min(curr, last);
        return map.get(last).pop();
    }

    public int popAtStack(int index) {
        if(!map.containsKey(index) || map.get(index).isEmpty()){
            return -1;
        }
        count--;
        curr=Math.min(curr, index);
        return map.get(index).pop();
    }
}
