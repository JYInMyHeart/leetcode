package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xck
 * @File: MinimumCostForTickets
 * @Time: 22:57 2020/2/1
 */
public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        Set<Integer> set = new HashSet<>();
        for (int i : days) {
            set.add(i);
        }
        for (int i = 1; i < 366; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = Math.min(dp[Math.max(i - 1, 0)] + costs[0],
                Math.min(dp[Math.max(i - 7, 0)] + costs[1],
                    dp[Math.max(i - 30, 0)] + costs[2]));


        }
        return dp[days[days.length - 1]];
    }
}
