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

//        System.out.println(spiralOrder(a));
        System.out.println(new DiagonalTraverse().longestCommonPrefix(new String[]{"asb","asfa","asfa"},0,2));

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


    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;

        if(len == 0) return "";
        int min = Arrays.stream(strs).map(String::length).min(Integer::compareTo).get();

        int[] i = {0};
        for(;i[0] < min;i[0]++){
            if(!Arrays.stream(strs).allMatch(x -> x.charAt(i[0]) == strs[0].charAt(i[0]))) break;
        }
        return strs[0].substring(0,i[0]);
    }

    public String longestCommonPrefix1(String[] strs) {
        int len = strs.length;

        if(len == 0) return "";
        int min = Arrays.stream(strs).map(String::length).min(Integer::compareTo).get();

        int left = 0;
        int right = min;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(helper(strs,mid)){
                left = mid + 1;
            }else
                right = mid - 1;
        }
        return strs[0].substring(0,(left + right) / 2);
    }


    public boolean helper(String[] strs, int index){
        for(int i = 0;i < strs.length;i++){
            if(!strs[i].startsWith(strs[0].substring(0,index)))
                return false;
        }
        return true;
    }


    public String longestCommonPrefix(String[] strs,int l,int r){
        if(l >= r) return strs[l];
        int mid = (r - l) / 2 + l;
        String left = longestCommonPrefix(strs,l,mid);
        String right = longestCommonPrefix(strs,mid + 1,r);
        return helper(left,right);
    }

    public String helper(String str1,String str2){
        int i = 0;
        while (i < (Math.min(str1.length(),str2.length()))){
            if(str1.charAt(i) != str2.charAt(i))
                return str1.substring(0,i);
            i++;
        }
        return str1.length() > str2.length() ? str2 : str1;
    }
}
