package array;

/**
 * @Author: xck
 * @File: StrobogrammaticNumber
 * @Time: 15:59 2019/12/17
 */
public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        StringBuffer bf = new StringBuffer();
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) - '0' == 9) {
                bf.append(6);
            } else if (num.charAt(i) - '0' == 6) {
                bf.append(9);
            } else if (num.charAt(i) - '0' == 0 || num.charAt(i) - '0' == 8
                || num.charAt(i) - '0' == 1) {
                bf.append(num.charAt(i));
            } else {
                return false;
            }

        }
        return num.equals(bf.toString());
    }
}

