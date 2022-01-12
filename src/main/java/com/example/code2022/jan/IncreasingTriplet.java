package com.example.code2022.jan;

/**
 * 中等题
 * 贪心
 * 20220112
 */
class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int x = nums[0];
        int y = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > y) {
                return true;
            } else if (num > x) {
                y = num;
            } else {
                x = num;
            }
        }
        return false;
    }
}