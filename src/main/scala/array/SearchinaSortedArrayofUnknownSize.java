package array;

/**
 * @Author: xck
 * @File: SearchinaSortedArrayofUnknownSize
 * @Time: 17:59 2019/4/13
 */
public class SearchinaSortedArrayofUnknownSize {
    class ArrayReader{
        public int get(int index){
            return 0;
        }
    }
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            right <<= 1;
        }

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (reader.get(mid) == target) return mid;
            else if (reader.get(mid) > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;

    }
}
