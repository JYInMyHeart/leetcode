package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: xck
 * @File: UniqueWordAbbreviation
 * @Time: 11:16 2019/12/4
 */
public class UniqueWordAbbreviation {
    Map<String,Integer> map = new HashMap<>();
    Set<String> cache;

    public UniqueWordAbbreviation(String[] dictionary) {
        cache = new HashSet<>();

        for(String str:dictionary){
            cache.add(str);

        }
        for(String str:cache){
            String tmp = str.length() > 2 ? ("" + str.charAt(0) + (str.length() - 2) + str.charAt(str.length() - 1)) : str;
            map.put(tmp,map.getOrDefault(tmp,0) + 1);
        }
    }

    public boolean isUnique(String str) {
        String tmp = str.length() > 2 ? ("" + str.charAt(0) + (str.length() - 2) + str.charAt(str.length() - 1)) : str;
        if(map.containsKey(tmp)) {
            if(map.get(tmp) > 1) return false;
            if(map.get(tmp) == 1 ){
                for(String s:cache){
                    if(s.equals(str)) return true;
                }
                return false;
            }
        }
        return true;
    }
}
