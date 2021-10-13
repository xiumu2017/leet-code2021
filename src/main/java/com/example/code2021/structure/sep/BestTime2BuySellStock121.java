package com.example.code2021.structure.sep;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTime2BuySellStock121 {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        final int i = maxProfit(arr);
        System.out.println(i);
        System.out.println(maxProfitPro(arr));

    }

    /**
     * 暴力法 超出时间限制
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        return max;
    }

    public static int maxProfitPro(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(price, min);
            max = Math.max(max, price - min);
        }
        return max;
    }
}
