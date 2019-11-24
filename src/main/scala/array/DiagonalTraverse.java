package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xck
 * @File: DiagonalTraverse
 * @Time: 11:36 2019/11/22
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int r = 0;
        boolean flag = true;
        for (int i = 0; i <= m + n - 2; i++) {
            if (flag) {
                for (int j = m - 1; j >= 0; j--) {
                    for (int k = n - 1; k >= 0; k--) {
                        if (j + k == i) {
                            res[r++] = matrix[j][k];
                        }
                    }
                }
            } else {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        if (j + k == i) {
                            res[r++] = matrix[j][k];
                        }
                    }
                }
            }
            flag = !flag;
        }
        return res;
    }

    public static int[] findDiagonalOrder1(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int r = 0;
        int c = 0;
        for(int i = 0;i < res.length;i++){
            res[i] = matrix[r][c];
            if((r + c) % 2 == 0){
                if(c == n - 1) r++;
                else if(r == 0) c++;
                else {
                    r--;
                    c++;
                }
            }else{
                if(r == m - 1) c++;
                else if(c == 0) r++;
                else {
                    r++;
                    c--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int[][] b = {
                {3,4,5}
        };
//        System.out.println(Arrays.toString(findDiagonalOrder1(a)));

        System.out.println(spiralOrder(a));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return result;
        int n = matrix[0].length;
        int top = m - 1;
        int bottom = 0;
        int left = 0;
        int right = n - 1;
        int max = m * n;
        int count = 1;
        int[][] tmp = new int[m][n];
        while(count <= max){
            int i1 = left;
            while(i1 <= right){
                tmp[bottom][i1++] = count++;
            }
            bottom++;
            int i2 = bottom;
            while(i2 <= top ){
                tmp[i2++][right] = count++;
            }

            right--;
            int i3 = right;
            while(i3 >= left){
                tmp[top][i3--] = count++;

            }

            top--;
            int i4 = top;
            while(i4 >= bottom){
                tmp[i4--][left] = count++;
            }

            left++;

        }

        Arrays.stream(tmp).flatMapToInt(Arrays::stream).forEach(result::add);
        //return result.size() > max ? result.subList(0,max) : result;
        return result;
    }

    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        StringBuilder buffer = new StringBuilder();
        int last = 0;
        while(m >= 0 || n >= 0){
            int sum = last;
            if(m >= 0) sum += a.charAt(m) - '0';
            if(n>= 0) sum += b.charAt(n) - '0';
            last = sum / 2;
            sum = sum % 2;
            buffer.append(sum);
            m--;
            n--;
        }
        if(last != 0) buffer.append(last);
        return buffer.reverse().toString();
    }
}
