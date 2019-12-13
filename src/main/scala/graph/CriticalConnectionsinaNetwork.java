package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xck
 * @File: CriticalConnectionsinaNetwork
 * @Time: 11:57 2019/12/13
 */
public class CriticalConnectionsinaNetwork {

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        int[] nums = new int[n];

        List<List<Integer>> result = new ArrayList<>();
        int len = connections.size();

        List<List<Integer>> temp = new ArrayList<>(connections);
        for (int i = 0; i < len; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            tmp.addAll(temp.subList(0,i));
            tmp.addAll(temp.subList(i + 1,len));
            Arrays.fill(nums, -1);
            if(!vaildGraph(n,tmp,nums))
                result.add(connections.get(i));
        }

        return result;
    }

    public static boolean vaildGraph(int n, List<List<Integer>> connections,int[] nums){

        for(List<Integer> list:connections){
            int src = list.get(0);
            int desc = list.get(1);
            int x = find(nums,src);
            int y = find(nums,desc);
            if(x == y) return false;
            nums[x] = y;
        }
        return connections.size() == n - 1;
    }

    public static int find(int[] nums, int index){
        if(nums[index] == -1) return index;
        return find(nums,nums[index]);
    }


    public static void main(String[] args) {
        //4
        //[[0,1],[1,2],[2,0],[1,3]]
        System.out.println(criticalConnections(4, Arrays
            .asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0),
                Arrays.asList(1, 3))));
    }

}
