package graph;

/**
 * @Author: xck
 * @File: TargetSum
 * @Time: 11:56 2019/4/24
 */
public class TargetSum {
    int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        helper(nums, 0, S);
        return res;
    }

    public void helper(int[] sums, int index, int sum) {
        if (index >= sums.length) {
            if (sum == 0) res++;
            return;
        }
        helper(sums, index + 1, sum + sums[index]);
        helper(sums, index + 1, sum - sums[index]);
    }


    public int findTargetSumWays1(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (S > sum || S < -sum) return 0;
        int[][] dp = new int[nums.length][sum * 2 + 1];
        dp[0][nums[0] + sum] = 1;
        dp[0][-nums[0] + sum] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (dp[i - 1][sum + j] != 0) {
                    dp[i][sum + j + nums[i]] += dp[i - 1][sum + j];
                    dp[i][sum + j - nums[i]] += dp[i - 1][sum + j];
                }
            }
        }
        return dp[nums.length - 1][sum + S];
    }

}
