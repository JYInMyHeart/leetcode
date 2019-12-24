package array;

/**
 * @Author: xck
 * @File: MaxIncreasetoKeepCitySkyline
 * @Time: 11:48 2019/12/24
 */
public class MaxIncreasetoKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int res = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                int max_left = 0;
                int max_top = 0;
                for(int x = 0;x < grid.length;x++){
                    max_left = Math.max(max_left,grid[x][j]);
                }
                for(int y = 0;y < grid[i].length;y++){
                    max_top = Math.max(max_top,grid[i][y]);
                }
                res += Math.min(max_left,max_top) - grid[i][j];
            }
        }
        return res;
    }
}
