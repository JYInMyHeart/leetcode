package string;

import java.util.*;

/**
 * @Author: xck
 * @File: WordPattern
 * @Time: 22:20 2019/4/21
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        String[] strings = str.split(" ");
        if(pattern.length() != strings.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals( strings[i])) return false;
            }else{
                map.put(pattern.charAt(i),strings[i]);
            }
        }
        return map.values().stream().distinct().count() == map.size();
    }

    public boolean wordPattern1(String pattern, String str) {
        Map<Object,Integer> map = new HashMap<>();
        String[] strings = str.split(" ");
        if(pattern.length() != strings.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if(!Objects.equals(map.put(pattern.charAt(i),i) , map.put(strings[i],i))) return false;
        }
        return true;
    }



    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i < 9;i += 3){
            for(int j = 0;j < 9;j += 3){
                if(!isValidPart(board,i,j))
                    return false;
            }
        }
        return isValidColumnAndRow(board);
    }

    public boolean isValidColumnAndRow(char[][] board){
        int n = board.length;
        for(int i = 0;i < n;i++){
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for(int j = 0;j < n;j++){
                if(board[i][j] != '.' && !set1.add(board[i][j])) return false;
                if(board[j][i] != '.' && !set2.add(board[j][i])) return false;
            }
        }
        return true;
    }

    public boolean isValidPart(char[][] board,int left,int right){
        Set<Character> set1 = new HashSet<>();

        for(int i = left;i < left + 3;i++){
            for(int j = right;j < right + 3;j++){
                if(board[i][j] == '.') continue;
                if(!set1.add(board[i][j]))
                    return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] c = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(new WordPattern().isValidSudoku(c));
    }
}
