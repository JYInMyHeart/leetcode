package string;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @Author: xck
 * @File: TopKFrequentWords
 * @Time: 15:26 2020/1/2
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0) + 1);
        }
        return map.entrySet().stream().sorted((e1,e2) -> {
            if(e1.getValue() > e2.getValue())
                return 1;
            else if(e1.getValue() < e2.getValue())
                return -1;
            else{
                return e1.getKey().compareToIgnoreCase(e2.getKey());
            }
        }).map(Entry::getKey).collect(Collectors.toList()).subList(0,k);

    }
}
