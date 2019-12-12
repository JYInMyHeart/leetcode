package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * @Author: xck
 * @File: PartitionArrayforMaximumSum
 * @Time: 9:47 2019/12/11
 */
public class PartitionArrayforMaximumSum {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int length = A.length;
        int[] dp = new int[length];

        for(int i = 0;i < length;i++){
            int curmax = 0;
            for(int j = 1;j <= K && i - j + 1 >= 0;j++){
                if(curmax < A[i - j + 1]){
                    curmax = A[i - j + 1];
                }
                dp[i] = Math.max(dp[i],(i >= j ? dp[i - j] : 0) + curmax * j);
            }
        }

        return dp[length - 1];

    }

}
