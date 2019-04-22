package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xck
 * @File: NumIslands
 * @Time: 1:55 2019/4/23
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    bfs(grid, i, j, visit);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int i, int j, boolean[][] visit) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int x = pair[0];
            int y = pair[1];


            visit[x][y] = true;
            if (x < grid.length - 1 && grid[x + 1][y] == '1' && !visit[x + 1][y]) {
                visit[x + 1][y] = true;
                queue.offer(new int[]{x + 1, y});
            }
            if (x > 0 && grid[x - 1][y] == '1' && !visit[x - 1][y]) {
                visit[x - 1][y] = true;
                queue.offer(new int[]{x - 1, y});
            }
            if (y < grid[0].length - 1 && grid[x][y + 1] == '1' && !visit[x][y + 1]) {
                visit[x][y + 1] = true;
                queue.offer(new int[]{x, y + 1});
            }
            if (y > 0 && grid[x][y - 1] == '1' && !visit[x][y - 1]) {
                visit[x][y - 1] = true;
                queue.offer(new int[]{x, y - 1});
            }


        }
    }

    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}
