package codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xck
 * @File: SortByHeight
 * @Time: 13:42 2019/4/20
 */
public class SortByHeight {
    static int[] sortByHeight(int[] a) {
        int len = a.length;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (a[i] == -1) {
                list.add(i);
            }
        }

        Arrays.sort(a);
        int[] res = new int[len];
        for (int i = 0; i < list.size(); i++) {
            res[list.get(i)] = -1;
        }
        int j = 0;
        for (int i = list.size(); i < len; i++) {
            while (res[j] == -1) j++;
            res[j++] = a[i];
        }
        return res;
    }
}
