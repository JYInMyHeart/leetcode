package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xck
 * @File: GroupthePeopleGiventheGroupSizeTheyBelongTo
 * @Time: 11:28 2019/12/24
 */
public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i < groupSizes.length;i++){
            List<Integer> list = map.getOrDefault(groupSizes[i],new ArrayList<>());
            if(list.size() == groupSizes[i]){
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(groupSizes[i],list);
        }
        res.addAll(map.values());
        return res;
    }
}
