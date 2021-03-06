package string;

/**
 * @Author: xcl
 * @File: AlphabetBoardPath
 * @Time: 0:24 2020/1/1
 */
public class AlphabetBoardPath {

    int x1 = 0, y1 = 0;

    public static void main(String[] args) {
        AlphabetBoardPath alphabetBoardPath = new AlphabetBoardPath();
        System.out.println(alphabetBoardPath.alphabetBoardPath("leet"));
    }

    public String alphabetBoardPath(String target) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < target.length(); i++) {
            sb.append(path(target.charAt(i)));
        }
        return sb.toString();
    }

    public String path(char a) {

        int x = (a - 'a') % 5;
        int y = (a - 'a') / 5;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Math.max(0, y1 - y); i++) {
            sb.append("U");
        }
        for (int i = 0; i < Math.max(0, x - x1); i++) {
            sb.append("R");
        }
        for (int i = 0; i < Math.max(0, x1 - x); i++) {
            sb.append("L");
        }
        for (int i = 0; i < Math.max(0, y - y1); i++) {
            sb.append("D");
        }
        sb.append("!");
        x1 = x;
        y1 = y;
        return sb.toString();
    }
}
