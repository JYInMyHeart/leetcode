package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xck
 * @File: HappyNumber
 * @Time: 10:37 2019/11/29
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(set.add(n)){
            if(n == 1) return true;
            n = helper(n);
        }
        return false;
    }

    public int helper(int n){
        String res = String.valueOf(n);
        int sum = 0;
        for(char c:res.toCharArray()){
            sum += ((c - '0') * (c - '0'));
        }
        return sum;
    }

    public boolean isHappy1(int n) {

        int slow = n;
        int fast = helper1(n);
        while( fast != 1 && slow != fast){
            fast = helper1(helper1(fast));
            slow = helper1(slow);
        }
        return fast == 1;
    }

    public int helper1(int n){
        int sum = 0;
        while(n > 0){
            sum += ((n % 10) * (n % 10));
            n = n /10;
        }
        return sum;
    }

    public static void main(String[] args) {
        new HappyNumber().isHappy1(19);
    }
}
