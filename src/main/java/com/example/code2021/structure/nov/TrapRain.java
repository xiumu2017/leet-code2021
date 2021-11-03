package com.example.code2021.structure.nov;

import java.util.Arrays;

/**
 * TrapRain
 *
 * @author Paradise
 * @date 2021/11/3 17:00
 **/
public class TrapRain {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 1, 2, 1, 3, 2, 1, 2, 1};
        System.out.println("new TrapRain().trap(arr) = " + new TrapRain().trap(arr));
    }

    /**
     * 动态规划的实现 （这就叫动态规划吗？）
     *
     * @param height 数组
     * @return 雨量
     */
    public int trap(int[] height) {

        final int length = height.length;
        // 左侧最大值
        int[] lm = new int[length];
        // 右侧最大值
        int[] rm = new int[length];

        lm[0] = height[0];
        rm[length - 1] = height[length - 1];
        for (int i = 1; i < length; i++) {
            lm[i] = Math.max(height[i], lm[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            rm[i] = Math.max(height[i], rm[i + 1]);
        }

        System.out.println(Arrays.toString(lm));
        System.out.println(Arrays.toString(rm));

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans = ans + Math.min(lm[i], rm[i]) - height[i];
        }
        return ans;
    }
}
