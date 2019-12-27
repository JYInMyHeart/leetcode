package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: xck
 * @File: SortCharactersByFrequency
 * @Time: 15:23 2019/12/27
 */
public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        List<Character> lst = new ArrayList<Character>();
        for (char c : array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            lst.add(c);
        }
        Map<Character, List<Character>> collect = lst.stream()
            .collect(Collectors.groupingBy(x -> x, Collectors.toList()));
        return collect.values().stream().flatMap(x -> x.stream())
            .sorted((a, b) -> map.get(b) - map.get(a)).map(x -> x + "")
            .collect(Collectors.joining());
    }
}
