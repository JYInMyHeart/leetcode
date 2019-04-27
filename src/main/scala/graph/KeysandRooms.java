package graph;

import java.util.List;
import java.util.Stack;

/**
 * @Author: xck
 * @File: KeysandRooms
 * @Time: 13:04 2019/4/27
 */
public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visit = new boolean[n];
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(rooms.get(0));
        visit[0] = true;
        while ((!stack.isEmpty())){
            List<Integer> room = stack.pop();
            for (Integer integer : room) {
                if (!visit[integer]) {
                    stack.push(rooms.get(integer));
                    visit[integer] = true;
                }
            }
        }
        for (boolean b:visit){
            if(!b)
                return false;
        }
        return true;
    }
}
