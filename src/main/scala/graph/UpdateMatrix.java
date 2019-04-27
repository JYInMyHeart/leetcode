package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xck
 * @File: UpdateMatrix
 * @Time: 12:03 2019/4/27
 */
public class UpdateMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;
    }

    public int[][] updateMatrix1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
       int[][]dp = new int[matrix.length][matrix[0].length];
        Arrays.stream(dp).forEach(x -> Arrays.fill(x,2147473647));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0)
                    dp[i][j] = 0;
                else{
                    if(i > 0)
                        dp[i][j] = Math.min(dp[i][j],dp[i - 1][j] + 1);
                    if(j > 0)
                        dp[i][j] = Math.min(dp[i][j],dp[i][j - 1] + 1);
                }
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if(i < matrix.length - 1)
                    dp[i][j] = Math.min(dp[i][j],dp[i + 1][j] + 1);
                if(j < matrix[0].length - 1)
                    dp[i][j] = Math.min(dp[i][j],dp[i][j + 1] + 1);
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        UpdateMatrix updateMatrix = new UpdateMatrix();
        int[][] a = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        updateMatrix.updateMatrix(a);
    }
}
