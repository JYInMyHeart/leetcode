package graph;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Finder1 {

    static int C = 0;
    static List<String> cheapestPath(int[][] t, Point start, Point finish) {
        int n = t.length;
        int m = t[0].length;
        if(start.x == finish.x && start.y == finish.y)return new ArrayList<>();
        return bfsRS1(t, start, finish, n, m);

    }

    @SuppressWarnings("unchecked")
    static ArrayList<String> bfsRS1(int[][] t, Point p, Point e, int n, int m){
        ArrayList dd[][] = new ArrayList[n][m];
        int dp[][] = new int[n][m];
        for(int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        Stack<Point> stack = new Stack<>();
        stack.add(p);
        dp[p.x][p.y] = 0;


        while(true){
            Stack<Point> secondary = new Stack<>();
            while(!stack.isEmpty()){
                Point q = stack.pop();
                int x = q.x;
                int y = q.y;
                if(x+1 < n && dp[x+1][y] > dp[x][y]+t[x+1][y]){
                    secondary.push(new Point(x+1, y));
                    dp[x+1][y] = dp[x][y]+t[x+1][y];

                    ArrayList<String> l = new ArrayList<>();
                    if(dd[x][y] != null)
                        l = new ArrayList<>(dd[x][y]);
                    l.add("down");
                    dd[x+1][y] = l;
                }
                if(x-1 >= 0 && dp[x-1][y] > dp[x][y]+t[x-1][y]){
                    secondary.push(new Point(x-1, y));
                    dp[x-1][y] = dp[x][y]+t[x-1][y];

                    ArrayList<String> l = new ArrayList<>();
                    if(dd[x][y] != null)
                        l = new ArrayList<>(dd[x][y]);
                    l.add("up");
                    dd[x-1][y] = l;
                }
                if(y+1 < m && dp[x][y+1] > dp[x][y]+t[x][y+1]){
                    secondary.push(new Point(x, y+1));
                    dp[x][y+1] = dp[x][y]+t[x][y+1];

                    ArrayList<String> l = new ArrayList<>();
                    if(dd[x][y] != null)
                        l = new ArrayList<>(dd[x][y]);
                    l.add("right");
                    dd[x][y+1] = l;
                }
                if(y-1 >= 0 && dp[x][y-1] > dp[x][y]+t[x][y-1]){
                    secondary.push(new Point(x, y-1));
                    dp[x][y-1] = dp[x][y]+t[x][y-1];

                    ArrayList<String> l = new ArrayList<>();
                    if(dd[x][y] != null)
                        l = new ArrayList<>(dd[x][y]);
                    l.add("left");
                    dd[x][y-1] = l;
                }
            }
            if(secondary.isEmpty())
                break;
            stack.addAll(secondary);
        }
        return dd[e.x][e.y];
    }

}