package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: xck
 * @File: OpenLock
 * @Time: 19:35 2019/4/23
 */
public class OpenLock {
    public static int openLock(String[] deadends, String target) {
        String start = "0000";
        Queue<String> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        queue.add(start);
        visit.add(start);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                String str = queue.poll();
                if(contain(deadends, str)) continue;
                if (str.equals(target)) return count - 1;
                for (int i = 0; i < 4; i++) {
                    String tmp1 = str.substring(0, i) + (((str.charAt(i)) + 1 - '0') % 10) + str.substring(i + 1);
                    String tmp2 = str.substring(0, i) + (((str.charAt(i)) + 9 - '0') % 10) + str.substring(i + 1);
                    if (!contain(deadends, tmp1) && !visit.contains(tmp1)) {
                        visit.add(tmp1);
                        queue.offer(tmp1);
                    }
                    if (!contain(deadends, tmp2)&& !visit.contains(tmp2)) {
                        visit.add(tmp2);
                        queue.offer(tmp2);
                    }
                }
            }
        }
        return -1;
    }

    public static boolean contain(String[] deadends, String tmp) {
        for (String s : deadends) {
            if (s.equals(tmp)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] d = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(openLock(d, "0202"));
    }
}
