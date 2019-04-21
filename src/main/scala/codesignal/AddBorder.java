package codesignal;

/**
 * @Author: xck
 * @File: AddBorder
 * @Time: 13:47 2019/4/20
 */
public class AddBorder {
    String[] addBorder(String[] picture) {
        int len = picture.length;
        String res[] = new String[len + 2];
        for (int i = 0; i < len; i++) {
            res[i + 1] = "*" + picture[i] + "*";
        }
        StringBuffer top = new StringBuffer();
        for (int i = 0; i < res[1].length(); i++) {
            top.append("*");
        }

        res[0] = top.toString();
        res[res.length - 1] = top.toString();
        return res;
    }
}
