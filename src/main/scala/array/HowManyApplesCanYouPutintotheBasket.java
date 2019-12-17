package array;

import java.util.Arrays;

/**
 * @Author: xck
 * @File: HowManyApplesCanYouPutintotheBasket
 * @Time: 15:48 2019/12/17
 */
public class HowManyApplesCanYouPutintotheBasket {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int i = 0;
        while(sum < 5000 && i < arr.length){
            sum += arr[i++];
        }
        return sum < 5000 ? i : i - 1 ;
    }
}
