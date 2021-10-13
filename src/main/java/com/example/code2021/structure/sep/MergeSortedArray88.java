package com.example.code2021.structure.sep;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        int[] nums11 = new int[]{1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums22 = new int[]{2, 5, 6};
        int n1 = 3;
        merge2(nums11, m1, nums22, n1);
        System.out.println(Arrays.toString(nums11));
    }

    /**
     * copy and sort
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 逆序，双指针
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1;
        int r = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (l < 0) {
                nums1[i] = nums2[r];
                r--;
            } else if (r < 0) {
                nums1[i] = nums1[l];
                l--;
            } else if (nums1[l] >= nums2[r]) {
                nums1[i] = nums1[l];
                l--;
            } else {
                nums1[i] = nums2[r];
                r--;
            }
        }
    }
}
