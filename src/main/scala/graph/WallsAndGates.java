package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: xck
 * @File: WallsAndGates
 * @Time: 0:22 2019/4/23
 */
public class WallsAndGates {
    class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0)
                    queue.offer(new int[]{i,j});
            }
        }
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];
            if( x < rooms.length - 1 && rooms[x + 1][y] == Integer.MAX_VALUE){
                rooms[x + 1][y] = rooms[x][y] + 1;
                queue.offer(new int[]{x+1,y});
            }
            if(x > 0  && rooms[x - 1][y] == Integer.MAX_VALUE){
                rooms[x - 1][y] = rooms[x][y] + 1;
                queue.offer(new int[]{x - 1,y});
            }
            if( y < rooms[0].length - 1 && rooms[x][y + 1] == Integer.MAX_VALUE){
                rooms[x][y + 1] = rooms[x][y] + 1;
                queue.offer(new int[]{x,y + 1});
            }
            if(y > 0  && rooms[x][y - 1] == Integer.MAX_VALUE){
                rooms[x][y - 1] = rooms[x][y] + 1;
                queue.offer(new int[]{x,y - 1});
            }
        }
    }


    public void wallsAndGates1(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
    }

    private void dfs(int[][] rooms, int i, int j, int d) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
        rooms[i][j] = d;
        dfs(rooms, i - 1, j, d + 1);
        dfs(rooms, i + 1, j, d + 1);
        dfs(rooms, i, j - 1, d + 1);
        dfs(rooms, i, j + 1, d + 1);
    }
}
