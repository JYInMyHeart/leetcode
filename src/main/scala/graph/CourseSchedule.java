package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xck
 * @File: CourseSchedule
 * @Time: 10:51 2019/12/10
 */
public class CourseSchedule {
    final int WHITE = 0;
    final int GRAY = 1;
    final int BLACK = -1;
    Map<Integer, Integer> color = new HashMap<>();
    Map<Integer, List<Integer>> relation = new HashMap<>();
    boolean isPossible = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            color.put(i, WHITE);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][0];
            int desc = prerequisites[i][1];
            List<Integer> lst = relation.getOrDefault(src, new ArrayList<>());
            lst.add(desc);
            relation.put(src, lst);
        }

        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE)
                dfs(i);
        }
        return isPossible;
    }

    public void dfs(int index) {
        if (!isPossible) {
            return;
        }

        color.put(index, GRAY);
        List<Integer> lst = relation.getOrDefault(index, new ArrayList<>());
        for (int i : lst) {
            if (color.get(i) == WHITE)
                dfs(i);
            else if (color.get(i) == GRAY) {
                isPossible = false;
                return;
            }
        }

        color.put(index, BLACK);

    }
}

