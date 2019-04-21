package codesignal;

/**
 * @Author: xck
 * @File: KthDigit
 * @Time: 15:30 2019/4/20
 */
public class KthDigit {
    static int kthDigit(int n, int k) {
        String input = String.valueOf(n);
        return (int) input.charAt(k - 1) - '0';
    }
    int myMaxOfThree(int a, int b, int c) {
        return a > b ? a > c ? a : c : b > c ? b : c;
    }
    public static void main(String[] args) {
        System.out.println(kthDigit(578943, 2));
    }
}
