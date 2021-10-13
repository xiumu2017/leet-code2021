package com.example.code2021.structure.sep;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 2, 1};
        int[] a2 = new int[]{2, 2};
        final int[] intersect = intersect(a1, a2);
        System.out.println(Arrays.toString(intersect));

        int[] b1 = new int[]{4, 9, 5, 4};
        int[] b2 = new int[]{9, 4, 9, 8, 4};
        final int[] intersect1 = intersect(b1, b2);
        System.out.println(Arrays.toString(intersect1));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> anMap = new HashMap<>();
        if (nums1.length < nums2.length) {
            deal(nums1, nums2, map, anMap);
        } else {
            deal(nums2, nums1, map, anMap);
        }
        List<Integer> list = new ArrayList<>();
        anMap.forEach((k, v) -> {
            if (v > 1) {
                v = Math.min(v, map.get(k));
                for (int i = 0; i < v; i++) {
                    list.add(k);
                }
            } else {
                list.add(k);
            }

        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void deal(int[] nums1, int[] nums2, Map<Integer, Integer> map, Map<Integer, Integer> anMap) {
        for (int x : nums1) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        for (int j : nums2) {
            if (map.containsKey(j)) {
                if (anMap.containsKey(j)) {
                    anMap.put(j, anMap.get(j) + 1);
                } else {
                    anMap.put(j, 1);
                }
            }
        }
    }
}
