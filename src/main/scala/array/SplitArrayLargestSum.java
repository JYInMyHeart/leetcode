package array;

/**
 * @Author: xck
 * @File: SplitArrayLargestSum
 * @Time: 14:47 2019/4/22
 */

/**
 * The answer is between maximum value of input array numbers and sum of those numbers.
 * Use binary search to approach the correct answer. We have l = max number of array;
 * r = sum of all numbers in the array;Every time we do mid = (l + r) / 2;
 * Use greedy to narrow down left and right boundaries in binary search.
 * 3.1 Cut the array from left.
 * 3.2 Try our best to make sure that the sum of numbers between each two cuts (inclusive) is
 * large enough but still less than mid.
 * 3.3 We'll end up with two results: either we can divide the array into more than m subarrays or we cannot.
 * If we can, it means that the mid value we pick is too small because we've already tried our best to
 * make sure each part holds as many non-negative numbers as we can but we still have numbers left.
 * So, it is impossible to cut the array into m parts and make sure each parts is no larger than mid.
 * We should increase m. This leads to l = mid + 1;
 * If we can't, it is either we successfully divide the array into m parts and the sum of each part
 * is less than mid, or we used up all numbers before we reach m. Both of them mean that we should
 * lower mid because we need to find the minimum one. This leads to r = mid - 1;
 *
 *
 *
 * Introduction to this problem:
 * We can break this problem into two smaller problems:
 *
 * Given an array (A), number of cuts (CUTS), and the Largest sum of sub-arrays (MAX).
 * Can you use at most CUTS cuts to segment array A into CUTS + 1 sub-arrays,
 * such that the sum of each sub-array is smaller or equal to MAX?
 * Given a lower bound (left), an upper bound (right), an unknown bool array (B),
 * and an API uses i as input and tells you whether B[i] is true. If we know there exists an index k,
 * that B[i] is false when i < k, and B[i] is true when i >= k. What is the fastest way to find this k (the lower bound)?
 * Solution to the first sub-problem (Skip this part if you already knew how to solve 1st sub-problem):
 * For the first question, we can follow these steps:
 *
 * For each element in the array, if its value is larger than MAX,
 * we know it's not possible to cut this array into groups that the sum of all groups are smaller than MAX.
 * (Reason is straightforward, if A is [10, 2, 3, 5] and MAX is 6,
 * even you have 3 cuts by which you can cut A as [[10], [2], [3], [5]],
 * the group containing 10 will still be larger than 6).
 * Use greedy algorithm to cut A. Use an accumulator ACC to store the sum of the currently processed group,
 * and process elements in A one by one. For each element num,
 * if we add num with ACC and the new sum is still no larger than MAX,
 * we update ACC to ACC + num, which means we can merge num into the current group.
 * If not, we must use a cut before num to segment this array, then num will be the first element in the new group.
 * If we didn't go through A but already used up all cuts,
 * then it's not possible only using CUTS cuts to segment this array into groups to make sure sum of each sub-array is
 * smaller than MAX. Otherwise, if we can reach the end of A with cuts left (or use exactly CUTS cuts).
 * It's possible to do so.
 * Then the first question is solved.
 *
 * Solution to the second sub-problem(Skip this part if you already knew how to solve 2nd sub-problem):
 * The array B will be something like [false, false, ..., false, true, true, ..., true].
 * We want to find the index of the first true.
 * Use binary search to find this k. Keep a value mid, mid = (left + right) / 2. If B[mid] = false,
 * then move the search range to the upper half of the original search range, a.k.a left = mid + 1,
 * otherwise move search range to the lower half, a.k.a right = mid.
 * Why this algorithm is correct...
 * No matter how we cut the array A, the Largest sum of sub-arrays will fall into a range [left, right].
 * Left is the value of the largest element in this array. right is the sum of this array. (e.g.,
 * Given array [1, 2, 3, 4, 5], if we have 4 cuts and cut it as [[1], [2], [3], [4], [5]],
 * the Largest sum of sub-arrays is 5, it cannot be smaller. And if we have 0 cut,
 * and the only sub-array is [[1, 2, 3, 4, 5]], the Largest sum of sub-arrays is 15, it cannot be larger).
 * However, we cannot decide the number of cuts (CUTS), this is an given constraint.
 * But we know there must be a magic number k, which is the smallest value of the Largest sum
 * of sub-arrays when given CUTS cuts. When the Largest sum of sub-arrays is larger than k,
 * we can always find a way to cut A within CUTS cuts. When the Largest sum of sub-arrays is smaller than k,
 * there is no way to do this.
 * Example
 * For example, given array A [1, 2, 3, 4, 5]. We can use 2 cuts.
 *
 * No matter how many cuts are allowed, the range of the possible value of the Largest sum of sub-arrays is [5, 15].
 * When given 2 cuts, we can tell the magic number k here is 6, the result of segmentation is [[1, 2, 3], [4], [5]].
 * When Largest sum of sub-arrays is in range [6, 15], we can always find a way to cut this array within two cuts.
 * You can have a try.
 * However, when Largest sum of sub-arrays is in range [5, 5], there is no way to do this.
 * This mapped this problem into the second sub-problem. Bool array B here is
 * [5:false, 6:true, 7:true, 8:true, ..., 15:true].
 * We want to find the index i of the first true in B,
 * which is the answer of this entire question, and by solving the first sub-problem,
 * we have an API that can tell us given an i (Largest sum of sub-arrays),
 * whether B[i] is true (whether we can find a way to cut A to satisfy the constraint).
 * Below is the code with comment, just in case you don't have time to read the explanations above.
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }
        int left = max;

        int right = sum;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (valid(mid, nums, m)) {
                right = mid - 1;
            } else
                left = mid + 1;

        }
        return left;
    }

    public boolean valid(long target, int[] nums, int m) {
        int sum = 0;
        int count = 1;
        for (int n : nums) {
            sum += n;
            if (sum > target) {
                sum = n;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
