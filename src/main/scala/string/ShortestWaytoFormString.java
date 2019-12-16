package string;

/**
 * @Author: xck
 * @File: ShortestWaytoFormString
 * @Time: 14:30 2019/12/16
 */
public class ShortestWaytoFormString {

    public int shortestWay(String source, String target) {
        int i = 0,j = 0,count = 1;
        while(j < target.length()){
            if(!source.contains("" + target.charAt(j))) return -1;
            if(i == source.length()){
                count++;
                i = 0;
            }
            if(source.charAt(i) == target.charAt(j)){
                i++;j++;
            }else{
                i++;
            }
        }
        return count;
    }
}
