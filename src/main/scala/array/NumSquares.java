package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xck
 * @File: NumSquares
 * @Time: 20:21 2019/4/23
 */
public class NumSquares {
    public int numSquares(int n) {
        int min = Integer.MAX_VALUE;
        help(n,new ArrayList<>(),min);
        return min;
    }

    public void help(int n, List<Integer> list,int min) {
        if (n == 0) return;
        for (int i = 1; i < Math.sqrt(n); i++) {
            list.add(i);
            help(n - i * i,list,min);
            min = Math.min(list.size(),min);
        }
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(12));
    }
}
