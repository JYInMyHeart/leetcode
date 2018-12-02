package graph;
import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
public class Finder2 {
    static List<String> cheapestPath(int[][] t, Point start, Point finish) {
        int r = t.length, c = t[0].length;
        boolean visited[][] = new boolean[r][c];
        int cost[][] = new int[r][c];
        int max = Arrays.stream(t).flatMapToInt(Arrays::stream).sum();
        for(int[] row: cost) Arrays.fill(row, max);

        Dir[][] dir = new Dir[r][c];

        // do a BFS on the map
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt((Point p) -> cost[p.x][p.y]));
        cost[start.x][start.y] = t[start.x][start.y];

        queue.add(start);
        while(!queue.isEmpty()){
            Point p1 = queue.poll();
            if(visited[p1.x][p1.y])
                continue;
            visited[p1.x][p1.y] = true;
            int cost1 = cost[p1.x][p1.y];
            for(Dir d: Dir.values()){
                Point p2 = new Point(p1.x + d.dr, p1.y + d.dc);
                // bounds
                if(p2.x < 0 || p2.x >= r || p2.y < 0 || p2.y >= c)
                    continue;
                if(visited[p2.x][p2.y])
                    continue;
                int cost2 = cost[p2.x][p2.y];
                // if best path save decision
                if(cost1 + t[p2.x][p2.y] < cost2)
                {
                    dir[p2.x][p2.y] = d;
                    cost[p2.x][p2.y] = cost1 + t[p2.x][p2.y];
                }
                queue.add(p2);
            }
        }
        // trackback from finish
        LinkedList<String> res = new LinkedList<>();
        Point p1 = finish;
        Dir d = dir[p1.x][p1.y];
        while(d != null){
            res.addFirst(d.toString());

            p1 = new Point(p1.x - d.dr, p1.y - d.dc);
            d = dir[p1.x][p1.y];
        }

        return res;
    }

    static enum Dir{
        up(-1, 0),
        down(1, 0),
        left(0, -1),
        right(0, 1),
        ;
        public int dr;
        public int dc;
        Dir(int dr, int dc){
            this.dr = dr;
            this.dc = dc;
        }
    }

    public static void main(String[] args) {
        int[][]      tollMap  = {{1,9,1},{2,9,1},{2,1,1}};
        Point        start    = new Point(0,0),
                finish   = new Point(0,2);
        System.out.println(cheapestPath(tollMap, start, finish));
    }
}
