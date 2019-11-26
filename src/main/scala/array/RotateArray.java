package array;

/**
 * @Author: xck
 * @File: RotateArray
 * @Time: 14:18 2019/11/26
 */
public class RotateArray {
    public void rotate(int[] nums, int n) {
        int len = nums.length;
        for(int i = 0;i <  n ;i++){
            incr(nums);
        }
    }

    public static void incr(int[] nums){
        int tmp = nums[nums.length - 1];
        for(int i = nums.length - 1;i >= 1;i--){
            nums[i] = nums[i - 1];
        }
        nums[0] = tmp;
    }

    public static void rotate1(int[] nums, int n) {
        int len = nums.length;
        int start = 0;
        int count = 0;

        for(;count < len;start++){
            int prev = nums[start];
            int current = start;
            do{
                int next = (current + n) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while(current != start);
        }
    }

    public static void main(String[] args) {
        rotate1(new int[]{1,2,3,4,5,6,7},3);
    }
}
