package string;

import java.util.Arrays;

/**
 * @Author: xck
 * @File: ReverseWordsinaString
 * @Time: 12:18 2019/6/1
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        return Arrays.stream(s.split("\\s+")).reduce((a,b) -> b + " " + a).orElse("").trim();
    }
}
