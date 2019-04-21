package codesignal;

/**
 * @Author: xck
 * @File: ReverseInParentheses
 * @Time: 13:41 2019/4/20
 */
public class ReverseInParentheses {
    static String reverseInParentheses(String inputString) {
        char[] chars = inputString.toCharArray();
        int len = inputString.length();
        int[] stack = new int[len];
        int stackTop = -1;
        for (int i = 0; i < len; i++) {
            switch (inputString.charAt(i)) {
                case '(':
                    stack[++stackTop] = i;
                    break;
                case ')':
                    if (stackTop < 0) {
                        throw new IllegalArgumentException("Parenthesis mismatch");
                    }
                    for (int j = stack[stackTop--], k = i; j < k; j++, k--) {
                        char tmp = chars[j];
                        chars[j] = chars[k];
                        chars[k] = tmp;
                    }
            }
        }
        if (stackTop >= 0)
            throw new IllegalArgumentException("error");
        int o = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                case ')':
                    break;
                default:
                    chars[o++] = chars[i];
            }
        }
        return new String(chars, 0, o);
    }
}
