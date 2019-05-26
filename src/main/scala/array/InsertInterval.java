package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: xck
 * @File: InsertInterval
 * @Time: 23:14 2019/5/26
 */
public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0])
            list.add(intervals[i++]);
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval = new int[]{ // we could mutate newInterval here also
                    Math.min(newInterval[0], intervals[i][0]),
                    Math.max(newInterval[1], intervals[i][1])};
            i++;
        }
        list.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.length) list.add(intervals[i++]);
        int[][] result = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            result[j] = list.get(j);
        }
        return result;
    }

//    public List<int[]> insert(List<int[]> intervals, int[] newInterval) {
//        List<int[]> result = new LinkedList<>();
//        int i = 0;
//        // add all the intervals ending before newInterval starts
//        while (i < intervals.size() && intervals.get(i)[1] < newInterval[0])
//            result.add(intervals.get(i++));
//        // merge all overlapping intervals to one considering newInterval
//        while (i < intervals.size() && intervals.get(i)[0] <= newInterval[1]) {
//            newInterval = new int[]{ // we could mutate newInterval here also
//                    Math.min(newInterval[0], intervals.get(i)[0]),
//                    Math.max(newInterval[1], intervals.get(i)[1])};
//            i++;
//        }
//        result.add(newInterval); // add the union of intervals we got
//        // add all the rest
//        while (i < intervals.size()) result.add(intervals.get(i++));
//        return result;
//    }

    public static void main(String[] args) {
        insert(new int[][]{{1,5}},new int[]{0,3});
    }
}
