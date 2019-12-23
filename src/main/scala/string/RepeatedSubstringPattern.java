package string;

/**
 * @Author: xck
 * @File: RepeatedSubstringPattern
 * @Time: 17:22 2019/12/23
 */
public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = 0;i < len;i++){
            if(i > 0 && len % i == 0){
                String tmp = s.substring(0,i);
                String temp = "";
                for(int j = 0;j < len / i;j++){
                    temp += tmp;
                }
                if(temp.equals(s)) return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern1(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abba"));
        System.out.println(repeatedSubstringPattern("abab"));
    }
}
