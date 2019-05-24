package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xck
 * @File: NQueens
 * @Time: 22:41 2019/5/24
 */
public class NQueensII {
    int count = 0;
    public int totalNQueens(int n) {

        char[][] test = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                test[i][j] = '.';
        helper(test,0,n);
        return count;
    }



    public void helper( char[][] nQueues, int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for(int col = 0;col < n;col++){
            if(valid(nQueues,n,row,col)){
                nQueues[row][col] = 'Q';
                helper(nQueues,row + 1,n);
                nQueues[row][col] = '.';
            }
        }
    }

    public boolean valid(char[][] demo, int n, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (demo[i][col] == 'Q')
                return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (demo[i][j] == 'Q')
                return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (demo[i][j] == 'Q')
                return false;


        return true;
    }
}
