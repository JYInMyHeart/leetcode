package string;

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
        StringBuffer buffer = new StringBuffer();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!buffer.toString().contains("" + s.charAt(i))) {
                if (count >= 2) {
                   char end = buffer.charAt(buffer.length() - 1);
                   StringBuffer tmp = new StringBuffer();
                   for(int j = buffer.length() - 1;j > 0;j--){
                       if(buffer.charAt(j) != end){
                           break;
                       }
                       tmp.append(end);
                   }
                   buffer = tmp;
                }else
                    count++;
            }
            buffer.append(s.charAt(i));
            max = Math.max(buffer.length(), max);
        }
        return max;
    }

    public static void main(String[] args) {
        String test = "ababacccccc";
        lengthOfLongestSubstringTwoDistinct(test);
    }
}
