package com.example.code2021.structure.dec;

/**
 * 2021-12-29
 */
class CountQuadruplets {
    public static void main(String[] args) {
        System.out.println(new CountQuadruplets().countQuadruplets(new int[]{3, 3, 6, 4, 5}));
        System.out.println(new CountQuadruplets().countQuadruplets(new int[]{1, 1, 1, 3, 5}));
        System.out.println(new CountQuadruplets().countQuadruplets(new int[]{28, 8, 49, 85, 37, 90, 20, 8}));
    }

    public int countQuadruplets(int[] nums) {
        final int length = nums.length;
        int ans = 0;
        for (int i = 0; i <= length - 3; i++) {
            for (int j = i + 1; j <= length - 2; j++) {
                for (int l = j + 1; l <= length - 1; l++) {
                    final int k = nums[i] + nums[j] + nums[l];
                    for (int x = l + 1; x < length; x++) {
                        if (nums[x] == k) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}