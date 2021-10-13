package com.example.code2021.structure.sep;

/**
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 */
public class N1221SplitStringBalancedStrings {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }

    public static int balancedStringSplit(String s) {
        final char[] chars = s.toCharArray();
        int d = 0;
        int ans = 0;
        for (char c : chars) {
            if (c == 'L') {
                d++;
            } else {
                d--;
            }
            if (d == 0) {
                ans++;
            }
        }
        return ans;
    }
}
