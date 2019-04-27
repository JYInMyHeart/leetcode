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

    public static void main(String[] args) {
        String s = "3[b2[c]]";
//        System.out.println(decodeString(s));
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("user.dir","aaa");
        System.out.println(System.getProperty("user.dir"));
    }
}
