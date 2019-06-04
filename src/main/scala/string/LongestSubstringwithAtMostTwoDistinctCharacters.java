package string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: xck
 * @File: LongestSubstringwithAtMostTwoDistinctCharacters
 * @Time: 12:26 2019/6/2
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
            if(map.size() > 2){
                map.remove(map.keySet().stream().findFirst().get());
            }else {
                int val = map.values().stream().reduce((a,b) -> a + b).get();
                max = Math.max(max,val);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String test = "ababacccccc";
        lengthOfLongestSubstringTwoDistinct(test);
    }
}
