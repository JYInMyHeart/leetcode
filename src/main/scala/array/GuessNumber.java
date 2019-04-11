package array;

/**
 * @Author: xck
 * @File: GuessNumber
 * @Time: 22:45 2019/4/11
 */
public class GuessNumber {
    static int pre = 6;
    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(guess(mid) == 0) return mid;
            else if(guess(mid)  > 0) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    public static int guess(int n){
        if(n < pre) return -1;
        else if(n > pre) return 1;
        else return 0;
    }
}
