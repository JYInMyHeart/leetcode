package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xck
 * @File: ReadNCharactersGivenRead4
 * @Time: 13:54 2019/6/1
 */
public class ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        boolean eof = false;      // end of file flag
        int total = 0;            // total bytes have read
        char[] tmp = new char[4]; // temp buffer

        while (!eof && total < n) {
            //raed4 api
//            int count = read4(tmp);
            int count = 4;

            // check if it's the end of the file
            eof = count < 4;

            // get the actual count
            count = Math.min(count, n - total);

            // copy from temp buffer to buf
            for (int i = 0; i < count; i++)
                buf[total++] = tmp[i];
        }

        return total;
    }
}
