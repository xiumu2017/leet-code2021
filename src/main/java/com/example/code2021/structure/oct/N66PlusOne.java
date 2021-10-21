package com.example.code2021.structure.oct;

import java.util.Arrays;

/**
 * N453MinimumMovesEqualArrayElements
 *
 * @author Paradise
 * @date 2021/10/20 11:22
 **/
public class N66PlusOne {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println("this.minMoves(arr) = " + Arrays.toString(new N66PlusOne().plusOne(new int[]{1, 2, 9, 9})));
        System.out.println("this.minMoves(arr) = " + Arrays.toString(new N66PlusOne().plusOne(arr)));
        System.out.println("this.minMoves(arr) = " + Arrays.toString(new N66PlusOne().plusOne(new int[]{9, 9, 9})));

    }

    // 最理想情况，最后一位 + 1 即可
    // 最糟糕情况，所有位置都是9 需要进位
    public int[] plusOne(int[] digits) {
        final int length = digits.length;
        if (digits[length - 1] < 9) {
            digits[length - 1] = digits[length - 1] + 1;
            return digits;
        }
        boolean flag = true;
        int[] ans = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            if (flag) {
                if (digits[i] == 9) {
                    ans[i] = 0;
                } else {
                    ans[i] = digits[i] + 1;
                    flag = false;
                }
            } else {
                ans[i] = digits[i];
            }
        }
        // 全是 9
        if (flag) {
            int[] ans2 = new int[length + 1];
            ans2[0] = 1;
            // 这一步循环是多余的
            for (int i = 1; i < length; i++) {
                ans2[i] = 0;
            }
            return ans2;
        }
        return ans;
    }
}

