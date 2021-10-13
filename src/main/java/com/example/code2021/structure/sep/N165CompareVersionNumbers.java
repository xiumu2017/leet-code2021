package com.example.code2021.structure.sep;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class N165CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001.1.2"));
        System.out.println(compareVersion("1.01.4", "1.0001"));
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.01.003.1", "1.001"));
        System.out.println(compareVersion("1.01", "1.001.0"));
    }

    public static int compareVersion(String version1, String version2) {
        int[] arr1 = Arrays.stream(version1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(version2.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int l1 = arr1.length;
        int l2 = arr2.length;
        final int min = Math.min(l1, l2);
        final int max = Math.max(l1, l2);
        for (int i = 0; i < min; i++) {
            if (arr1[i] > arr2[i]) {
                return 1;
            } else if (arr1[i] < arr2[i]) {
                return -1;
            }
            if (i == min - 1) {
                if (l1 == l2) {
                    return 0;
                }
                // 还要判断长的那个，是否元素都是0
                for (int j = i + 1; j < max; j++) {
                    if (l1 > l2) {
                        if (arr1[j] > 0) {
                            return 1;
                        }
                    } else {
                        if (arr2[j] > 0) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        }
        return 0;
    }

}
