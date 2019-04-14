package array;

/**
 * @Author: xck
 * @File: FindSmallestLetterGreaterThanTarget
 * @Time: 21:29 2019/4/14
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(letters[mid] <= target) left = mid + 1;
            else right = mid;
        }
        if(left < letters.length && letters[left] > target) return letters[left];
        else return letters[0];
    }

    public char nextGreatestLetter1(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        while(left < right){
            int mid = (right - left) / 2 + left;
            if(letters[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return letters[left % letters.length];
    }
}
