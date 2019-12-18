package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xck
 * @File: RemoveInterval
 * @Time: 10:38 2019/12/18
 */
public class RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int[][] temp = new int[intervals.length + 1][2];
        for(int i = 0;i < intervals.length;i++){
            temp[i] = intervals[i];
        }
        temp[intervals.length] = toBeRemoved;
        Arrays.sort(temp,(a,b) -> a[0] != b[0] ? a[0] - b[0]:b[1] - a[1]);
        List<List<Integer>> res = new ArrayList<>();
        for(int[] v:temp){
            if(v[0] < toBeRemoved[0]){
                res.add(Arrays.asList(v[0],v[1] > toBeRemoved[0] ? toBeRemoved[0] : v[1]));
            }
            if(v[1] > toBeRemoved[1]){
                res.add(Arrays.asList(toBeRemoved[1] > v[0] ? toBeRemoved[1] : v[0],v[1]));
            }
        }
        return res;
    }
}
