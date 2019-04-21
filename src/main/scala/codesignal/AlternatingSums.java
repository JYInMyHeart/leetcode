package codesignal;

/**
 * @Author: xck
 * @File: AlternatingSums
 * @Time: 13:42 2019/4/20
 */
public class AlternatingSums {
    int[] alternatingSums(int[] a) {
        int len = a.length;
        int odd = 0;
        int even = 0;
        for (int i = 0; i < len; i++) {
            if((i & 1) == 0){
                odd += a[i];
            }else
                even += a[i];
        }
        return new int[]{odd,even};
    }

    public static void main(String[] args) {
        System.out.println(2 & 1);
        System.out.println(3 & 1);
    }
}
