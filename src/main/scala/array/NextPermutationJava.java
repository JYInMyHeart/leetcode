package array;

import java.util.Arrays;

/**
 * @Author: xck
 * @File: NextPermutationJava
 * @Time: 19:04 2019/3/27
 */
public class NextPermutationJava {
    public static void soultion(int[] nums){
        for(int i = nums.length - 2;i >= 0;i--){
            if(nums[i] < nums[i + 1]){
                for(int j = nums.length - 1;j > i ; j--){
                    if(nums[j] > nums[i]){
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
                reverseArray(nums,i + 1,nums.length - 1);
                return;
            }
        }
        reverseArray(nums,0,nums.length - 1);
    }

    private static  void reverseArray(int[] nums, int begin, int end){
        for(int i = begin, j = end;i<j;i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        soultion(new int[]{1,2,3});
    }
}
