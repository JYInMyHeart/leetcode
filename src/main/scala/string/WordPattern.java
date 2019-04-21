package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: xck
 * @File: WordPattern
 * @Time: 22:20 2019/4/21
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        String[] strings = str.split(" ");
        if(pattern.length() != strings.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals( strings[i])) return false;
            }else{
                map.put(pattern.charAt(i),strings[i]);
            }
        }
        return map.values().stream().distinct().count() == map.size();
    }

    public boolean wordPattern1(String pattern, String str) {
        Map<Object,Integer> map = new HashMap<>();
        String[] strings = str.split(" ");
        if(pattern.length() != strings.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if(!Objects.equals(map.put(pattern.charAt(i),i) , map.put(strings[i],i))) return false;
        }
        return true;
    }
}
