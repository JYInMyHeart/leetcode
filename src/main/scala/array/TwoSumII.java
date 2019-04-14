package array;

/**
 * @Author: xck
 * @File: TwoSumII
 * @Time: 22:35 2019/4/14
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i = 0;i < numbers.length;i++){
            int mid = binarySearch(numbers,target - numbers[i],i);
            if(mid != -1){
                res[0] = i + 1;
                res[1] = mid + 1;
                break;
            }
        }
        return res;
    }

    public int binarySearch(int[] nums,int target,int start){
        int left = start + 1;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] == target) return mid;
            else right = mid - 1;
        }
        return -1;
    }

    public int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int v = numbers[left] + numbers[right];
            if(v == target){
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }else if(v > target)
                right--;
            else
                left++;
        }
        return res;
    }
}
