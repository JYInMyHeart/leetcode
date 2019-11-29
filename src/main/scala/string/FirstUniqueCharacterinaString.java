package string;

/**
 * @Author: xck
 * @File: FirstUniqueCharacterinaString
 * @Time: 13:27 2019/11/29
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }

        for(int i = 0; i < s.length();i++)
            if(map.get(s.charAt(i)) == 1)
                return i;

        return -1;
    }
}
