package com.example.code2021.structure.sep;

/**
 * N639DecodeWaysII
 *
 * @author Paradise
 * @date 2021/9/27 09:07
 **/
public class N639DecodeWaysII {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        final N639DecodeWaysII ii = new N639DecodeWaysII();
        final int n639DecodeWaysII = ii.numDecodings("135*78112");
        System.out.println("n639DecodeWaysII = " + n639DecodeWaysII);
    }

    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c = f[i]
        long a = 0;
        long b = 1;
        long c = 0;
        for (int i = 1; i <= n; ++i) {
            c = b * check1digit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    public int check1digit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    public int check2digits(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }
            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;
    }
}
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/decode-ways-ii/solution/jie-ma-fang-fa-ii-by-leetcode-solution-23af/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
