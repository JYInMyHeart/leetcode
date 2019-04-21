package codesignal;

/**
 * @Author: xck
 * @File: IsSumOfConsecutive2
 * @Time: 14:43 2019/4/20
 */
public class IsSumOfConsecutive2 {
    static int isSumOfConsecutive2(int n) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;
        for(;j < n;){
            while(sum < n){
                sum += j;
                j++;
            }
            while(sum > n){
                sum -= i;
                i++;
            }
            if(sum == n){
                System.out.println(sum);
                count++;
                System.out.println(i + ".." + j);
                j++;
                sum += j;
                i++;
                sum -= i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(isSumOfConsecutive2(1));
    }

}
