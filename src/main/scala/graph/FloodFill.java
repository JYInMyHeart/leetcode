package graph;

import java.util.Stack;

/**
 * @Author: xck
 * @File: FloodFill
 * @Time: 11:42 2019/4/27
 */
public class FloodFill {

    /*
     * [[1,1,1],  [[2,2,2],
     *  [1,1,0],   [2,2,0],
     *  [1,0,1]]   [2,0,1]]
     * */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if(originalColor == newColor) return image;
        dfs(image,sr,sc,newColor,originalColor);
        return image;
    }


    int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public void dfs(int[][] image, int sr, int sc, int newColor,int originalColor) {
        image[sr][sc] = newColor;
        for (int[] direction:directions){
            int x = sr + direction[0];
            int y = sc + direction[1];
            if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != originalColor) continue;
            image[x][y] = newColor;
            dfs(image,x,y,newColor,originalColor);
        }
    }

    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if(originalColor == newColor) return image;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr,sc});
        while(!stack.isEmpty()){
            int[] original = stack.pop();
            sr = original[0];
            sc = original[1];
            image[sr][sc] = newColor;
            for (int[] direction:directions){
                int x = sr + direction[0];
                int y = sc + direction[1];
                if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != originalColor) continue;
                image[x][y] = newColor;
                stack.push(new int[]{x,y});
            }
        }
        return image;
    }

    public static void main(String[] args) {

        /*
        * 0 0 0
        * 0 1 0
        * */
    }
}
