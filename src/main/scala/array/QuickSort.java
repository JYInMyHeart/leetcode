package array;

import java.util.Arrays;

/**
 * @Author: xck
 * @File: QuickSrot
 * @Time: 11:43 2019/12/6
 */
public class QuickSort {
    public int partition(int[] nums,int left,int right){
        int mid = nums[(right - left) / 2 + left];
        int i = left,j = right;
        while (i < j){
            while(nums[i] < mid) i++;
            while(nums[j] > mid) j--;
            if(i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    public void quickSort(int[] nums,int left,int right){
        System.out.println(Arrays.toString(nums));
        if(left < right - 1){
            int p = partition(nums,left,right);
            quickSort(nums,left,p - 1);
            quickSort(nums,p,right);
        }
    }

    public static void main(String[] args) {
        int[] a = {4,3,7,5,2,1,6,0,8};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a,0,a.length - 1);
    }
}
