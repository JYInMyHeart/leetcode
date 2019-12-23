package string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: xck
 * @File: MaximumNumberofOccurrencesofaSubstring
 * @Time: 10:17 2019/12/23
 */
public class MaximumNumberofOccurrencesofaSubstring {

    public static void main(String[] args) {
        MaximumNumberofOccurrencesofaSubstring maximumNumberofOccurrencesofaSubstring = new MaximumNumberofOccurrencesofaSubstring();
        System.out.println(maximumNumberofOccurrencesofaSubstring.maxFreq("aababcaab", 2, 3, 4));
        System.out.println(maximumNumberofOccurrencesofaSubstring.maxFreq("aabcabcab", 2, 2, 3));
        System.out
            .println(maximumNumberofOccurrencesofaSubstring.maxFreq("abcabababacabcabc", 3, 3, 10));

    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> cache = new HashMap<>();
        int lo = 0;
        int hi = 0;
        while (hi <= s.length() && lo <= hi) {
            String tmp = s.substring(lo, hi);
            if (multiLetters(tmp, maxLetters) && tmp.length() >= minSize) {
                cache.put(tmp, cache.getOrDefault(tmp, 0) + 1);
                lo++;
            } else {
                if (!multiLetters(tmp, maxLetters)) {
                    lo++;
                } else {
                    hi++;
                }
            }
        }
        return cache.values().stream().max(Comparator.comparingInt(a -> a)).orElse(0);

    }

    public boolean multiLetters(String s, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size() <= maxLetters;
    }
}
