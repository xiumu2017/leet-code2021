package com.example.code2021.structure;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubarray53 {
    public static void main(String[] args) {

        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 不太好理解的动态规划
     *
     * @param nums 数组
     * @return max
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            max = Math.max(pre, max);
        }
        return max;
    }
}
