package graph;

import java.util.Arrays;

/**
 * @Author: xck
 * @File: DungeonGame
 * @Time: 11:46 2019/5/28
 */
public class DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[m][ n -1] = dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
               int need = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j] ;
                dp[i][j] = need <= 0 ? 1 : need;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        calculateMinimumHP(a);


    }
}
