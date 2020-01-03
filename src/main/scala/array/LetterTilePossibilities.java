package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: xck
 * @File: LetterTilePossibilities
 * @Time: 22:07 2020/1/3
 */
public class LetterTilePossibilities {
    List<String> set = new ArrayList<>();
    boolean[] vis;
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        vis = new boolean[n];
        dfs(new StringBuilder(), tiles);
        System.out.println(set);
        return set.size();
    }
    void dfs(StringBuilder sb, String tiles){
        if(sb.length()>0) set.add(sb.toString());
        if(sb.length()>=tiles.length()) return;
        for(int i=0;i<tiles.length();i++){
            if(vis[i]) continue;
            vis[i] = true;
            int len = sb.length();
            dfs(sb.append(tiles.charAt(i)), tiles);
            sb.setLength(len);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        LetterTilePossibilities l = new LetterTilePossibilities();
        l.numTilePossibilities("AB");
//        [A, AA, AAB, AABB, AABBA, AABBAB]
    }
}
