package com.example.code2021.structure;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 */
public class N566ReshapeMatrix {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3, 4}, {0, 4, 5, 6}, {40, 41, 5, 6}};
        final int[][] ans = matrixReshape(mat, 2, 6);
        for (int[] a : ans) {

            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int cell = mat[0].length;
        int total = row * cell;
        if (r * c != total) {
            return mat;
        }
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int v = i * c + j;
                ans[i][j] = mat[v / cell][v % cell];
            }
        }
        return ans;
    }
}
