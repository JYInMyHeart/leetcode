package test;


import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(test(4,4));
        System.out.println(josephus(4,4));
    }

    static int test(int n,int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add( i + 1);
        }
        int count = 1;
        int index = 0;
        while (list.size() > 1) {

            if (count == m) {
                list.remove(((index) % n));
                count = 1;
            }
            count++;
            index++;
        }
        System.out.println(list);

        return list.get(0);
    }

    public static int josephus(int n, int m) {
        int s = 0;
        for (int i = 2; i <= n; i++) {
            //每轮出局的人的序号
            s = (s + m) % i;
        }
        //编号1开始
        return s + 1;
    }

    static boolean check(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i != -1) count++;
        }
        return count == 1;

    }


}
