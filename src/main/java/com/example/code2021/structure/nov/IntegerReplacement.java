package com.example.code2021.structure.nov;

class IntegerReplacement {
    public static void main(String[] args) {
        final IntegerReplacement integerReplacement = new IntegerReplacement();
        final int i = integerReplacement.integerReplacement2(Integer.MAX_VALUE);
        System.out.println(i);

    }

    public int integerReplacement(int n) {
        System.out.print(n);
        System.out.print(" -> ");
        int ans = 0;
        while (n > 1) {
            if (isO(n)) {
                n = n / 2;
            } else {
                n = n + 1;
            }
            ans++;
        }
        System.out.print(ans);
        System.out.println();
        return ans;
    }

    public int integerReplacementPub(int n) {
        System.out.print(n);
        System.out.print(" -> ");
        int ans = 0;
        if (n == Integer.MAX_VALUE) {
            n = (n - 1) / 2 + 1;
            ans += 2;
        }
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 4 == 1 || n == 3) {
                n = n - 1;
            } else if (n % 4 == 3) {
                n = n + 1;
            }
            ans++;
        }
        System.out.print(ans);
        System.out.println();
        return ans;
    }

    public int integerReplacement2(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ++ans;
                n /= 2;
            } else if (n % 4 == 1) {
                ans += 2;
                n /= 2;
            } else {
                if (n == 3) {
                    ans += 2;
                    n = 1;
                } else {
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/integer-replacement/solution/zheng-shu-ti-huan-by-leetcode-solution-swef/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public boolean isO(int n) {
        return n % 2 == 0;
    }
}