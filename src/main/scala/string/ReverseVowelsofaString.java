package string;

/**
 * @Author: xck
 * @File: ReverseVowelsofaString
 * @Time: 12:48 2019/12/19
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        StringBuffer sb = new StringBuffer();
        StringBuffer res = new StringBuffer();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U')
                sb.append(s.charAt(i));
        }
        int len = sb.length() - 1;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U'){
                res.append(sb.charAt(len--));
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
