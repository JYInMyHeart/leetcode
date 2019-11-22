package array;

/**
 * @Author: xck
 * @File: PivotIndex
 * @Time: 10:35 2019/11/22
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        for(int i = 0;i < nums.length ;i++){
            int sumLeft = 0;
            int sumRight = 0;
            for(int j = 0;j < i;j++) sumLeft += nums[j];
            for(int k = nums.length - 1;k > i;k--) sumRight += nums[k];
            if(sumLeft == sumRight) return i;
        }
        return -1;
    }

    public static int pivotIndex1(int[] nums) {
        int[] pre = new int[nums.length];
        if(nums.length == 0) return -1;
        pre[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            pre[i] = pre[i - 1] + nums[i];
        }

        for(int i = 0;i < nums.length;i++){
            if(pre[i] - nums[i] == pre[nums.length - 1] - pre[i])
                return i;
        }



        return -1;
    }

    public static void main(String[] args) {
        pivotIndex1(new int[]{-1,-1,-1,-1,-1});
    }
}
