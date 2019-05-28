package array;

/**
 * @Author: xck
 * @File: BitwiseANDofNumbersRange
 * @Time: 11:07 2019/5/28
 */
public class BitwiseANDofNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {
//        for (int i = 1; Math.pow(2,i) < Integer.MAX_VALUE; i++) {
//            if(m == Math.pow(2,i - 1) - 1 )
//                return n;
//            if(n == Math.pow(2,i - 1) - 1 )
//                return m;
//            if(m < Math.pow(2,i) && m >= Math.pow(2,i - 1) && n < Math.pow(2,i) && n >= Math.pow(2,i - 1))
//                return (int) Math.pow(2,i - 1);
//        }
//        return 0;
        while(m<n) n = n & (n-1);
        return n;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(1, 1));
    }
}
