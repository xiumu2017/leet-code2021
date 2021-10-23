package com.example.code2021.structure.oct;

/**
 * N492ConstructRectangle
 *
 * @author Paradise
 * @date 2021/10/23 22:58
 **/
public class N492ConstructRectangle {
    public static int[] constructRectangle(int area) {
        int v = (int) Math.sqrt(area);
        for (; v > 1; v--) {
            if (area % v == 0) {
                return new int[]{area / v, v};
            }
        }
        return new int[]{area, 1};
    }
}
