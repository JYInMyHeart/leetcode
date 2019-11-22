package array;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(findDiagonalOrder1(a)));
    }
}
