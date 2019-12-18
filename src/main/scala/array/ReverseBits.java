package array;

/**
 * @Author: xck
 * @File: ReverseBits
 * @Time: 10:48 2019/12/18
 */
public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(200));
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }
}
