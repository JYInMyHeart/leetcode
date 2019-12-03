package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xck
 * @File: LongestSubstringWithoutRepeatingCharacters
 * @Time: 14:28 2019/12/3
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;

        StringBuffer buffer = new StringBuffer();
        for(int i = 0;i < s.length();i++){
            int count = 0;
            Set<Character> set = new HashSet<>();
            for(int j = i ;j < s.length();j++){
                if(set.add(s.charAt(j))){
                    count++;
                }else
                    break;
            }
            max = Math.max(max,count);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {

        int max = 0;
        Set<Character> set = new HashSet<>();
        int j = 0;
        for(int i = 0;i < s.length();){
            if(!set.contains( s.charAt(i))){
                set.add(s.charAt(i));
                i++;
            }else{
                set.remove( s.charAt(j++));
            }
            max = Math.max(set.size(),max);
        }
        return max;
    }
}
