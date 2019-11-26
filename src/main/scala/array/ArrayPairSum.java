package array;

/**
 * @Author: xck
 * @File: ArrayPairSum
 * @Time: 11:36 2019/11/26
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        int[] arr = new int[20001];
        int lim = 10000;
        for(int i:nums)
            arr[lim + i]++;
        int d = 0;
        for(int i = -10000;i <= 10000;i++){
            // for example [1,2,3,4]
            // it means u got 1 if d == 1
            // then u can't got 2 because u should got lower one.
            // so d should add 2 to skip 2.
            // but if u didn't get 1 so u should get 2.
            // so u should minus last d's value to choose next num.
            sum += (arr[lim + i] + 1 - d) / 2 * i;
            d = (2 + arr[lim + i] - d) % 2;
        }
        return sum;
    }
}
