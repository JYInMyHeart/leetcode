package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: xck
 * @File: GroupShiftedStrings
 * @Time: 11:32 2019/12/3
 */
public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            map.put(helper(s), new ArrayList<>());
        }
        for (String s : strs) {
            map.get(helper(s)).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public String helper(String str) {
        StringBuilder buffer = new StringBuilder();
        char[] chars = str.toCharArray();
        if (str.length() > 0) {
            int dis = 'z' - str.charAt(0);
            for (char c : chars) {
                buffer.append((c - '0' + dis) % 26 + '0');
            }
        }
        return buffer.toString();
    }
}

