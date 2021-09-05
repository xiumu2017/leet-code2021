package com.example.code2021.offer;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib(50000));

        System.out.println(Arrays.toString(fibArr(10)));
        System.out.println(Arrays.toString(fibArr(20)));
    }

    public static int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p;
        int q = 0;
        int r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }

    public static int[] fibArr(int n) {
        int[] ans = new int[n];
        if (n == 1) {
            return new int[]{0};
        }
        if (n == 2) {
            return new int[]{0, 1};
        }
        int p;
        int q;
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i < n; ++i) {
            p = ans[i - 2];
            q = ans[i - 1];
            ans[i] = p + q;
        }
        return ans;
    }


//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/fei-bo-na-qi-shu-lie-by-leetcode-solutio-hbss/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
