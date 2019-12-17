package string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xck
 * @File: SequentialDigits
 * @Time: 16:09 2019/12/17
 */
public class SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i = low;i <= high;i++){
            if(isSequentialDigits(i))
                res.add(i);
        }
        return res;
    }

    public static boolean isSequentialDigits(int num){
        int n = num;
        while(n > 0){
            if(n < 10) return true;
            int tempN = n / 10;
            int tempMod = n % 10;
            if((tempN % 10) + 1 != tempMod) return false;
            n = tempN;
        }
        return true;
    }

    public static List<Integer> sequentialDigits1(int low, int high) {
        String core = "123456789";
        List<Integer> lst = new ArrayList<>();
        for(int i = 2;i < 10;i++){
            for(int j = 0;j + i < 10;j++){
                lst.add(Integer.valueOf(core.substring(j,j + i)));
            }
        }

        return lst.stream().filter(i -> i <= high && i >= low).collect(Collectors.toList());


    }

    public static void main(String[] args) {
        System.out.println(sequentialDigits1(100,300));
    }
}
