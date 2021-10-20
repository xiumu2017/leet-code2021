package com.example.code2021.structure.oct;

import java.util.Arrays;

/**
 * N453MinimumMovesEqualArrayElements
 *
 * @author Paradise
 * @date 2021/10/20 11:22
 **/
public class N453MinimumMovesEqualArrayElements {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println("this.minMoves(arr) = " + new N453MinimumMovesEqualArrayElements().minMoves(arr));

    }

    public int minMoves(int[] nums) {
        final int[] min = new int[1];
        Arrays.stream(nums).min().ifPresent(value -> min[0] = value);
        int ans = 0;
        for (int num : nums) {
            ans += num - min[0];
        }
        return ans;
    }
}

