package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xck
 * @File: SubarraySumsDivisiblebyK
 * @Time: 20:29 2019/4/21
 */
public class SubarraySumsDivisiblebyK {
    public static int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for(int a : A) {
            sum = (sum + a) % K;
            if(sum < 0) sum += K;
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        subarraysDivByK(new int[]{4,5,0,-2,-3,1},5);
    }
}
