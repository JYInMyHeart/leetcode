package array;

/**
 * @Author: xck
 * @File: MovingAverage
 * @Time: 19:25 2019/4/22
 */
public class MovingAverage {
    private int [] window;
    private int n, insert;
    private long sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
    }

    public double next(int val) {
        if (n < window.length)  n++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;

        return (double)sum / n;
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));//= 1
        System.out.println(m.next(10));/// = (1 + 10) / 2
        System.out.println(m.next(3) );///= (1 + 10 + 3) / 3
        System.out.println(m.next(5) );///= (10 + 3 + 5) / 3
    }
}
