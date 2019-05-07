package string;

/**
 * @Author: xck
 * @File: D
 * @Time: 23:32 2019/5/7
 */
public class D {
    static int left = 0;
    static int maxlen = 0;
    public static int longestPalindrome(final String s) {

        if(s.length() <= 1) return s.length();
        for(int i = 1 ;i < s.length();i++){
            getPalinedromicIndex(s,i - 1,i);
            getPalinedromicIndex(s,i - 1,i - 1);
        }
        return s.substring(left,left + maxlen).length();
    }
    public static void getPalinedromicIndex(String s, int start, int end) {
        int st = start;
        int en = end;
        while(st >= 0 && en < s.length() && s.charAt(st--) == s.charAt(en++));
        if(maxlen < en - st - 1){
            left = st + 1;
            maxlen = en - st - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aab"));
//        System.out.println(longestPalindrome("zyabyz"));
//
//        System.out.println(longestPalindrome("baa"));

    }
}
