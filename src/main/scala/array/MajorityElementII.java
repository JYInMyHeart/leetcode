package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xck
 * @File: MajorityElementII
 * @Time: 19:05 2019/12/10
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue() > nums.length / 3){
                list.add(e.getKey());
            }
        }
        return list;
    }
}
