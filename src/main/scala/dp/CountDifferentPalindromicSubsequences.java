package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: xck
 * @File: CountDifferentPalindromicSubsequences
 * @Time: 10:38 2020/1/15
 */
public class CountDifferentPalindromicSubsequences {

    final int M = 1000000007;
    int sum = 0;
    Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        CountDifferentPalindromicSubsequences countDifferentPalindromicSubsequences = new CountDifferentPalindromicSubsequences();
        String S = "bccb";
        System.out.println(countDifferentPalindromicSubsequences.countPalindromicSubsequences1(S));
        System.out.println(countDifferentPalindromicSubsequences.countPalindromicSubsequences1(
            "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }

    public int countPalindromicSubsequences(String S) {
        boolean[] visited = new boolean[S.length()];
        Set<String> set = new HashSet<>();
        int count = 0;
        dfs(S, new StringBuilder(), set, visited, 0);
        return sum % M;
    }

    public void dfs(String S, StringBuilder stringBuilder, Set<String> set, boolean[] visited,
        int start) {
        if (stringBuilder.length() > 0) {
            if (set.add(stringBuilder.toString()) && isPalindromic(stringBuilder.toString())) {
                sum++;
            }
        }
        if (stringBuilder.length() >= S.length()) {
            return;
        }
        for (int i = start; i < S.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int len = stringBuilder.length();
            stringBuilder.append(S.charAt(i));
            dfs(S, stringBuilder, set, visited, i);
            visited[i] = false;
            stringBuilder.setLength(len);
        }
    }

    public boolean isPalindromic(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j && str.charAt(i) == str.charAt(j)) {
            i++;
            j--;
        }
        return i == j || j + 1 == i;
    }

    public int countPalindromicSubsequences1(String S) {
        final int M = 1000000007;
        int len = S.length();
        int[][][] dp = new int[4][len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                for (int k = 0; k < 4; k++) {
                    char c = (char) (k + 'a');
                    if (i == j) {
                        if (S.charAt(i) == c) {
                            dp[k][i][j] = 1;
                        } else {
                            dp[k][i][j] = 0;
                        }
                    } else {
                        if (S.charAt(i) != c) {
                            dp[k][i][j] = dp[k][i + 1][j];
                        } else if (S.charAt(j) != c) {
                            dp[k][i][j] = dp[k][i][j - 1];
                        } else {
                            if (i + 1 == j) {
                                dp[k][i][j] = 2;
                            } else {
                                dp[k][i][j] = 2;
                                for (int l = 0; l < 4; l++) {
                                    dp[k][i][j] += dp[l][i + 1][j - 1];
                                    dp[k][i][j] %= M;
                                }
                            }

                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int k = 0; k < 4; ++k) {
            ans += dp[k][0][len - 1];
            ans %= M;
        }

        return ans;
    }
}
