package array;

/**
 * @Author: xck
 * @File: ArmstrongNumber
 * @Time: 10:46 2019/12/18
 */
public class ArmstrongNumber {
    public boolean isArmstrong(int N) {
        int n = N;
        double sum = 0;
        int len = 0;
        while(n > 0){
            n = n /10;
            len++;
        }
        n = N;
        while(n > 0){
            int mod = n % 10;
            n = n / 10;
            sum += Math.pow(mod,len);

        }
        return sum == (double)N;
    }
}
