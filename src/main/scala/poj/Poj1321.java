package poj;

import java.util.Scanner;

/**
 * @Author: xck
 * @File: Poj1321
 * @Time: 11:31 2020/1/1
 */
public class Poj1321 {

    static int n,k;
    static int ans = 0;
    static boolean[] visited = new boolean[n];
    static char[][] board = new char[n][n];
    public static void dfs(int start,int chessNum){
        if(chessNum == k){
            ans++;
            return ;
        }
        for(int i = start;i < n;i++){
            for(int j = 0;j < n;j++){
                if(!visited[j] && board[i][j] == '#'){
                    visited[j] = true;
                    dfs(start + 1,chessNum + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int nn = scanner.nextInt();
            int kk = scanner.nextInt();
            if(nn == kk && kk == -1)
                break;
            for(int i = 0;i < nn;i++){
                for(int j = 0;j < nn;j++){
                    board[i][j] = scanner.next().charAt(0);
                }
            }
            n = nn;
            k = kk;
            dfs(0,0);
            System.out.println(ans);
        }

    }



}
