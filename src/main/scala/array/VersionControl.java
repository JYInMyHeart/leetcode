package array;

/**
 * @Author: xck
 * @File: VersionControl
 * @Time: 10:24 2019/4/13
 */
public class VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right  = n;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        if(left != n && isBadVersion(left)) return left;
        return n;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}
