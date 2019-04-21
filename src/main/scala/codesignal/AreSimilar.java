package codesignal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xck
 * @File: AreSimilar
 * @Time: 13:55 2019/4/20
 */
public class AreSimilar {
    boolean areSimilar(int[] a, int[] b) {
        int index = 0;
        List<Integer> indexList = new ArrayList<>();
        if(a.length != b.length) return false;
        for(int i = 0;i < a.length;i++){
            if(a[i] != b[i]){
                indexList.add(i);
                index++;
            }
        }
        return index == 0 || (index == 2 && a[indexList.get(0)] == b[indexList.get(1)] && a[indexList.get(1)] == b[indexList.get(0)]);

    }
}
