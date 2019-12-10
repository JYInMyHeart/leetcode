package array;

/**
 * @Author: xck
 * @File: UglyNumberIII
 * @Time: 19:34 2019/12/10
 */
public class UglyNumberIII {
    private long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private int count(long a, long b, long c, long num) {
        return (int) ((num / a) + (num / b) + (num / c)
            - (num / lcm(a, b))
            - (num / lcm(b, c))
            - (num / lcm(a, c))
            + (num / lcm(a, lcm(b, c)))); // lcm(a,b,c) = lcm(a,lcm(b,c))
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int low = 1, high = Integer.MAX_VALUE, mid;

        while (low < high) {
            mid = low + (high - low) / 2;

            if (count((a), b, c, mid) < n)
                low = mid + 1;
            else
                high = mid;
        }

        return high;
    }

    public static void main(String[] args) {
//        nthUglyNumber(3,2,3,5);
    }
}
