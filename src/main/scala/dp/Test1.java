package dp;

import java.util.Arrays;

/**
 * @Author: xck
 * @File: Test1
 * @Time: 11:59 2019/5/13
 */
public class Test1 {
    public static int test(int[] a,int target){
        int[][] dp = new int[a.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= a.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= target; j++) {
                if(j - a[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j - a[i - 1]] + dp[i - 1][j] ;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[a.length][target];
    }

    public static void main(String[] args) {
        System.out.println(test(new int[]{4,3,2,1}, 6));
    }
}
