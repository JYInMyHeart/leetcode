package string;

/**
 * @Author: xck
 * @File: StrStar
 * @Time: 20:16 2019/11/24
 */
public class StrStar {
    public int strStr(String haystack, String needle) {
        int pointer = 0;
        int start = -1;
        if(needle.equals("")) return 0;
        if(needle.length() > haystack.length()) return -1;
        for(int i = 0;i < haystack.length();){
            start = i;
            while(pointer < needle.length() && i < haystack.length() && haystack.charAt(i) == needle.charAt(pointer)){
                i++;
                pointer++;
            }
            if(pointer == needle.length()) return start;
            else{
                pointer = 0;
                i = start + 1;
                start = -1;
            }
        }
        return start ;
    }
}
