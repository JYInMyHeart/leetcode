package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: xck
 * @File: NumberofSquarefulArrays
 * @Time: 18:26 2020/1/20
 */
public class NumberofSquarefulArrays {

    public static void main(String[] args) {
        int a[] = {1,1,1,1,1,1,1,1,1,1,1};
        NumberofSquarefulArrays n = new NumberofSquarefulArrays();
        System.out.println(n.numSquarefulPerms(a));
    }

//    public int numSquarefulPerms(int[] A) {
//        int fac[] = new int[A.length];
//        fac[0] = 1;
//
//        for (int i = 1; i < A.length; i++) {
//            fac[i] = fac[i - 1] * i;
//
//        }
//        Set<String> res = new HashSet<>();
//        for (int i = 0; i < fac[fac.length - 1] * fac.length; i++) {
//            int temp = i;
//            List<Integer> lst = new ArrayList<>();
//            lst.add(A[0]);
//            for (int k = 1; k < A.length; k++) {
//                lst.add(A[k]);
//            }
//            StringBuilder sb = new StringBuilder();
//            for (int j = A.length - 1; j > -1; j--) {
//                int idx = temp / fac[j];
//                temp %= fac[j];
//                sb.append(lst.get(idx)).append("_");
//                lst.remove(idx);
//            }
//            res.add(sb.toString());
//        }
//
//        int count = 0;
//        for (String t : res) {
//            if (isSquare(t)) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public boolean isSquare(String str) {
//        String[] arr = str.split("_");
//        for (int i = 1; i < arr.length; i++) {
//            int sum = Integer.valueOf(arr[i]) + Integer.valueOf(arr[i - 1]);
//            double sqrt = Math.sqrt(sum);
//            if (sqrt * sqrt != sum) {
//                return false;
//            }
//        }
//        return true;
//    }


    int count = 0;

    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        dfs(A, new ArrayList<>(), new boolean[A.length]);
        return count;
    }

    public void dfs(int[] A, List<Integer> list, boolean[] used) {
        if (list.size() == A.length) {
            count++;
            return;
        }
        for (int i = 0; i < A.length; i++) {
            if (used[i] || (i - 1 >= 0 && A[i] == A[i - 1] && !used[i - 1])) {
                continue;
            }
            if (list.size() == 0 || isSquare(list.get(list.size() - 1) + A[i])) {
                list.add(A[i]);
                used[i] = true;
                dfs(A, list, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    public boolean isSquare(int x) {
        double r = Math.sqrt(x);
        if ((r - Math.floor(r)) == 0) {
            return true;
        }
        return false;

    }
}
