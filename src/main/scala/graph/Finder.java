package graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Map;
import java.util.PriorityQueue;

public class Finder {

    final private static Point[] MOVES = {new Point(1,0), new Point(0,1), new Point(0,-1), new Point(-1,0)};

    final private static Map<Point,String> BACK = new HashMap<Point, String>() {{
        put(new Point(1, 0), "down");
        put(new Point(0, 1), "right");
        put(new Point(0, -1), "left");
        put(new Point(-1, 0), "up");
    }};


    static List<String> cheapestPath(int[][] t, Point start, Point finish) {

        final int lX = t.length, lY = t[0].length;

        PriorityQueue<Tup> q    = new PriorityQueue<Tup>() {{ add(new Tup(0, false, start)); }};
        Map<Point,Tup> seen = new HashMap<Point,Tup>() {{ put(start, new Tup(0, false, new Point(0,0))); }};


        while (!q.isEmpty() && !finish.equals(q.peek().pos)) {

            final Tup curr     = q.poll();
            final int nextCost = curr.cost + t[curr.pos.x][curr.pos.y];

            Arrays.stream(MOVES)
                    .map(     p ->   new Point(curr.pos.x+p.x, curr.pos.y+p.y) )
                    .filter(  p ->   0 <= p.x && p.x < lX && 0 <= p.y && p.y < lY
                            && (!seen.containsKey(p) || seen.get(p).cost > nextCost) )
                    .forEach( p -> { seen.put(p, new Tup(nextCost, false, curr.pos) );
                        q.add(new Tup(nextCost, finish.equals(p), p));
                    });
        }

        List<String> path = new ArrayList<>();
        Point        pos  = finish;

        while (!start.equals(pos)) {
            Tup   saw   = seen.get(pos);
            Point delta = new Point(pos.x-saw.pos.x, pos.y-saw.pos.y);
            path.add( BACK.get(delta) );
            pos = saw.pos;
        }
        Collections.reverse(path);

        return path;
    }


    /* ******************
          HELPER CLASS
       ******************/

    private static class Tup implements Comparable<Tup> {
        protected int cost;
        protected boolean isEnd;
        protected Point pos;

        protected Tup(int cost, boolean isEnd, Point pos) {
            this.pos = pos;
            this.cost = cost;
            this.isEnd = isEnd;
        }

        @Override public String toString() { return String.format("Tup(%d, %d, (%d,%d))", cost, isEnd ? 1:0, pos.x, pos.y); }

        @Override public boolean equals(Object other) {
            if (other == null || !(other instanceof Tup)) return false;
            Tup that = (Tup) other;
            return cost == that.cost && isEnd == that.isEnd && pos == that.pos;
        }

        @Override public int compareTo(Tup other) {
            return cost  != other.cost  ?  cost - other.cost
                    : isEnd != other.isEnd ? (isEnd ? 1:0) - (other.isEnd ? 1:0)
                    : pos.x != other.pos.x ? pos.x - other.pos.x
                    :                        pos.y - other.pos.y;
        }
    }


}