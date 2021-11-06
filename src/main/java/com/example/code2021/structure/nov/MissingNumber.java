package com.example.code2021.structure.nov;

import java.util.Arrays;

class MissingNumber {
    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumberBit(new int[]{1}));
        System.out.println(new MissingNumber().missingNumberBit(new int[]{0}));
    }

    // 高斯求和公式
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long total = (long) n * (n + 1) / 2;
        return (int) (total - Arrays.stream(nums).sum());
    }

    // 位运算 异或
    public int missingNumberBit(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        for (int i = 0; i <= n; i++) {
            ans ^= i;
        }
        return ans;
    }
}