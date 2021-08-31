package com.example.code2021.structure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RepeatItem {
    public static void main(String[] args) {
        final int[] nums = {1, 2, 3, 1};
        final boolean containsDuplicate = containsDuplicate(nums);
        System.out.println(containsDuplicate);

        System.out.println(containsDuplicate2(nums));
        System.out.println(containsDuplicate3(nums));
        System.out.println(containsDuplicate4(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() != nums.length;
    }

    public static boolean containsDuplicate2(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    /**
     * Hash 法
     */
    public static boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 排序法
     */
    public static boolean containsDuplicate4(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
