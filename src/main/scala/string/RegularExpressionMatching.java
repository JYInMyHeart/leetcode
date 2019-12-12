package string;

/**
 * @Author: xck
 * @File: RegularExpressionMatching
 * @Time: 18:12 2019/12/12
 */
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() &&
            (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2)) ||
                (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }


    public static void main(String[] args) {
//        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("ssissippi", "s*is*p*."));

    }
}
