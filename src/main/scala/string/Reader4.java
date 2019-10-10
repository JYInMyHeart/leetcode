package string;

/**
 * @Author: xck
 * @File: Reader4
 * @Time: 0:05 2019/10/11
 */
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */

    char[] previous = new char[4];
    int buffptr = 0;
    int count = 0;
    public int read(char[] buf, int n) {
        boolean eof = false;      // end of file flag
        int total = 0;
        while (!eof && total < n) {
            //raed4 api
            if(buffptr == 0){
                count = read4(previous);
            }



            // check if it's the end of the file
            eof = count < 4;

            // copy from temp buffer to buf
            while (total < n && buffptr < count)
                buf[total++] = previous[buffptr++];

            if(buffptr == count) buffptr = 0;


        }

        return total;
    }

    public int read4(char[] buf){
        return 0;
    }
}
