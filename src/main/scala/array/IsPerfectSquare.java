package array;

/**
 * @Author: xck
 * @File: IsPerfectSquare
 * @Time: 21:22 2019/4/14
 */
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (num / mid > mid)
                left = mid + 1;
            else if (num / mid < mid)
                right = mid - 1;
            else return num % mid == 0;

        }
        return false;
    }

    public boolean isPerfectSquareByNewTonMethod(int num) {
        long x = num;
        while (x * x > num) {
            x = (num / x + x) >> 1;
        }
        return x * x == num;
    }
}
