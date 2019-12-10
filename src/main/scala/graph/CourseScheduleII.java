package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xck
 * @File: CourseScheduleII
 * @Time: 18:29 2019/12/9
 */
public class CourseScheduleII {
    Map<Integer,Integer> color = new HashMap<>();
    Map<Integer,List<Integer>> relationship = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    final int WHITE = 0;
    final int BLACK = -1;
    final int GRAY = 1;
    boolean isPossible = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i = 0;i < numCourses;i++){
            color.put(i,WHITE);
        }
        for(int[] pre:prerequisites){
            int src = pre[0];
            int dest = pre[1];
            List<Integer> temp = relationship.getOrDefault(src,new ArrayList());

            temp.add(dest);
            relationship.put(src,temp);
        }
        for(int i = 0;i < numCourses;i++){
            if(color.get(i) == WHITE)
                dfs(i);
        }
        int[] res = new int[numCourses];
        if(isPossible){
            for(int i = 0;i < numCourses;i++){
                res[i] = result.get(i);
            }
        }else{
            res = new int[0];
        }
        return res;



    }

    public void dfs(int index){
        if(!isPossible) return;
        color.put(index,GRAY);
        List<Integer> list = relationship.getOrDefault(index,new ArrayList<>());
        for(int i:list){
            if(color.get(i) == WHITE){
                dfs(i);
            }else if(color.get(i) == GRAY){
                isPossible = false;
                return;
            }
        }
        color.put(index,BLACK);
        result.add(index);
    }
}

