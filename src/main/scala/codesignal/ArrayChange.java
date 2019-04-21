package codesignal;

/**
 * @Author: xck
 * @File: ArrayChange
 * @Time: 14:04 2019/4/20
 */
public class ArrayChange {
    static int arrayChange(int[] inputArray) {
        int moves = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            int height = inputArray[i + 1] - inputArray[i];
            if(height <= 0){
                moves += -height + 1;
                inputArray[i + 1] += -height + 1;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        System.out.println(arrayChange(new int[]{1, 1, 1}));
    }

}
