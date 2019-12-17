package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xck
 * @File: WildcardMatching
 * @Time: 14:28 2019/12/17
 */
public class WildcardMatching {

    public static void main(String[] args) {
        WildcardMatching w = new WildcardMatching();
        System.out.println(w.isMatch("aaaa", "***a"));
    }

    public boolean isMatch(String s, String p) {
        p = simple(p);
        Map<String, Boolean> map = new HashMap<>();
        return helper(s, p, map);
    }

    public boolean helper(String s, String p, Map<String, Boolean> map) {
        if (map.get(s + "_" + p) != null) {
            return map.get(s + "_" + p);
        }
        if (s.equals(p) || p.equals("*")) {
            map.put(s + "_" + p, true);
        } else if (p.equals("") || s.equals("")) {
            map.put(s + "_" + p, false);
        } else if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
            map.put(s + "_" + p,
                helper(s.substring(1, s.length()), p.substring(1, p.length()), map));
        } else if (p.charAt(0) == '*') {
            map.put(s + "_" + p,
                helper(s, p.substring(1, p.length()), map) || helper(s.substring(1, s.length()), p,
                    map));
        } else {
            map.put(s + "_" + p, false);
        }

        return map.get(s + "_" + p);
    }

    public String simple(String p) {
        StringBuffer buffer = new StringBuffer();
        for (char c : p.toCharArray()) {
            if (c == '*' && buffer.length() > 0 && buffer.charAt(buffer.length() - 1) == '*') {
                continue;
            }
            buffer.append(c);
        }
        return buffer.toString();
    }


    public boolean isMatch1(String s, String p) {
        int sp = 0, pp = 0, match = 0, start = -1;
        while (sp < s.length()) {
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                start = pp;
                match = sp;
                pp++;
            } else if (start != -1) {
                pp = start + 1;
                match++;
                sp = match;
            } else {
                return false;
            }
        }
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }
        return pp == p.length();
    }
}
