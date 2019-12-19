package string;

/**
 * @Author:xck
 * @File: RemoveVowelsfromaString
 * @Time: 12:39 2019/12/19
 */
public class RemoveVowelsfromaString {
    public String removeVowels(String S) {
        StringBuffer sb = new StringBuffer();
        for(char c:S.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                continue;
            sb.append(c);
        }
        return sb.toString();
    }
}
