package array;

import java.util.Arrays;

/**
 * @Author: xck
 * @File: FindKthSmallestPairDistance
 * @Time: 15:54 2019/4/22
 */


/**
 *
 * intuition
 *
 * Let's binary search for the answer. It's definitely in the range [0, W], where W = max(nums) - min(nums)].
 *
 * Let possible(guess) be true if and only if there are k or more pairs with distance less than or equal to guess.
 * We will focus on evaluating our possible function quickly.
 *
 * Algorithm
 *
 * Let prefix[v] be the number of points in nums less than or equal to v.
 * Also, let multiplicity[j] be the number of points i with i < j and nums[i] == nums[j].
 * We can record both of these with a simple linear scan.
 *
 * Now, for every point i, the number of points j with i < j and nums[j] - nums[i] <= guess is
 * prefix[x+guess] - prefix[x] + (count[i] - multiplicity[i]), where count[i] is the number of ocurrences of nums[i] in nums.
 * The sum of this over all i is the number of pairs with distance <= guess.
 *
 * Finally, because the sum of count[i] - multiplicity[i] is the same as the sum of multiplicity[i],
 * we could just replace that term with multiplicity[i] without affecting the answer. (Actually,
 * the sum of multiplicities in total will be a constant used in the answer, so we could precalculate it if we wanted.)
 *
 * In our Java solution, we computed possible = count >= k directly in the binary search instead of using a helper function.
 *
 */
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];

        for (int cnt = 0; l < r; cnt = 0) {
            int m = l + (r - l) / 2;


            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && nums[j] <= nums[i] + m) j++;
                cnt += j - i - 1;
            }

            if (cnt < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
