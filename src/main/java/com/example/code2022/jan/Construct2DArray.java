package com.example.code2022.jan;

import java.util.Arrays;

class Construct2DArray {

    public static void main(String[] args) {
        final int[][] its = new Construct2DArray().construct2DArray(new int[]{1, 2, 3, 4}, 2, 2);
        System.out.println(Arrays.toString(its));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < original.length; i += n) {
            System.arraycopy(original, i, ans[i / n], 0, n);
        }
        return ans;
    }
}