package array;

/**
 * @Author: xck
 * @File: SumOfSquareNum
 * @Time: 23:48 2019/12/19
 */
public class SumOfSquareNum {
    class Solution {
        public boolean judgeSquareSum(int c) {
            for (long a = 0; a * a <= c; a++) {
                double b = Math.sqrt(c - a * a);
                if (b == (int) b)
                    return true;
            }
            return false;
        }
    }
}
