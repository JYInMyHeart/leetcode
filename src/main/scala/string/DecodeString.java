package string;

import java.util.Stack;

/**
 * @Author: xck
 * @File: DecodeString
 * @Time: 11:00 2019/4/25
 */
public class DecodeString {
    public static String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Integer> times = new Stack<>();
        String tmp = "";
        Stack<String> contents = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {
            if (chars[i] == '[') {
                contents.push(tmp);
                tmp = "";
                i++;
            } else if (chars[i] == ']') {
                StringBuffer temp = new StringBuffer(contents.pop());
                int time = times.pop();
                for (int j = 0; j < time; j++) {
                    temp.append(tmp);
                }
                tmp = temp.toString();
                i++;
            } else if (Character.isDigit(chars[i])) {
                StringBuffer t = new StringBuffer();
                while (Character.isDigit(chars[i])) {
                    t.append(chars[i++]);
                }
                times.push(Integer.valueOf(t.toString()));
            } else {
                tmp += s.charAt(i++);
            }
        }
        return tmp;
    }

    public static int longestPalindrome(final String s) {
        int n = s.length();
        int[][] dp  = new int[n][n];
        int i = n - 1;
        dp[0][0] = 1;
        while(i >= 0 ){
            dp[i][i] = 1;
            for(int j = i + 1 ;j < n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
            i -= 1;
        }
        return dp[0][n - 1];
    }


    public static void main(String[] args) {
        String s = "3[b2[c]]";
//        System.out.println(decodeString(s));
        System.out.println(longestPalindrome("zyabyz"));
    }
}
