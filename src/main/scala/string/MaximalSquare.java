package string;

/**
 * @Author: xck
 * @File: MaximalSquare
 * @Time: 19:49 2020/1/12
 */
public class MaximalSquare {

    public static void main(String[] args) {
        char[][] a = new char[][]{{'1', '1'}, {'1', '1'}};
        MaximalSquare m = new MaximalSquare();
        System.out.println(m.maximalSquare(a));
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int len = 1;
                    boolean flag = true;
                    while (len + i < matrix.length && len + j < matrix[0].length && flag) {
                        for (int k = i; k <= len + i; k++) {
                            if (matrix[k][j + len] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = j; k <= len + j; k++) {
                            if (matrix[i + len][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            len++;
                        }
                    }
                    max = Math.max(len, max);
                }
            }
        }
        return max * max;
    }
}

