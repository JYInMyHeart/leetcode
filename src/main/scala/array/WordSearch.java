package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xck
 * @File: WordSearch
 * @Time: 23:15 2019/4/3
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        Map<Character,Integer> map = new HashMap<>();
        for(char[] chars:board){
            for(char c:chars){
                map.put(c,map.getOrDefault(c,0) + 1);
            }
        }
        for (char c:word.toCharArray()){
            if(map.get(c) == 0 || map.get(c) == null)
                return false;
            if(map.containsKey(c))
                map.put(c,map.get(c) - 1);
        }
        return true;
    }
}
