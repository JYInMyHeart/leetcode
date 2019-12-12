package dp;

/**
 * @Author: xck
 * @File: CountSquareSubmatriceswithAllOnes
 * @Time: 2:28 2019/12/13
 */
public class CountSquareSubmatriceswithAllOnes {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = matrix;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                count += dp[i][j];
            }
        }
        return count;
    }
}

