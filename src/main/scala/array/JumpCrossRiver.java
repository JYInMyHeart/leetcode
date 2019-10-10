package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xck
 * @File: JumpCrossRiver
 * @Time: 14:35 2019/7/13
 */
public class JumpCrossRiver {
    public  boolean canCross(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < stones.length; i++){
            list.add(stones[i]);
        }
        return f(list);
    }

    boolean f(List<Integer> list){
        for(int i = list.size() - 1;i >= 0;i--){
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if(Math.abs(list.get(j) - list.get(i)) < 2){
                    temp.add(j);
                }
            }
            if(temp.contains((Integer)0))
                return true;
            else{
                return temp.stream().map(x -> temp.subList(0, x)).anyMatch(this::f);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {0,1,3,5,6,8,12,17};
        new JumpCrossRiver().canCross(a);
    }
}
