package com.example.code2022.jan;

/**
 * Easy
 * 2022-1-7
 * <a href="https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/"></a>
 */
public class MaxDepth {
    public static void main(String[] args) {
        System.out.println(new MaxDepth().maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    public int maxDepth(String s) {
        int ans = 0;
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                x++;
            }
            if (s.charAt(i) == ')') {
                ans = Math.max(ans, x);
                x--;
            }
        }
        return ans;
    }
}