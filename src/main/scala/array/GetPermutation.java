package array;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: xck
 * @File: GetPermutation
 * @Time: 10:33 2019/4/2
 */
public class GetPermutation {
    public String getPermutation(int n, int k) {
        String original = Stream.iterate(1, x -> x + 1).limit(n).reduce((x, y) -> Integer.valueOf(String.valueOf(x) + y)).get().toString();
        List<String> res = new ArrayList<>();
        helper(original, res, new StringBuffer(), k);
        return res.get(k - 1);
    }


    public String getPermutation1(int n, int k) {
        StringBuffer sb = new StringBuffer();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1] * i;
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(i + 1);
        }
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / f[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * f[n - i];
        }
        return sb.toString();
    }

    private void helper(String original, List<String> res, StringBuffer sb, int k) {
        if (res.size() >= k) return;
        if (sb.length() == original.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < original.length(); i++) {
            if (sb.toString().contains(String.valueOf(original.charAt(i))))
                continue;
            sb.append(original.charAt(i));
            helper(original, res, sb, k);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        GetPermutation g = new GetPermutation();
        System.out.println(g.getPermutation1(4, 13));
    }
}
