package com.example.code2021.structure.nov;

import java.util.Random;

class ArrayShuffle {
    int[] nums;
    int[] original;
    Random random = new Random();

    public ArrayShuffle(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;
    }

    public int[] shuffle() {
        for (int i = 0; i < nums.length; ++i) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/shuffle-an-array/solution/da-luan-shu-zu-by-leetcode-solution-og5u/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。