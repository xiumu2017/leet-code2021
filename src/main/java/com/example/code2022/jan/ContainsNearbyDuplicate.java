package com.example.code2022.jan;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 简单题
 * 2022-1-19
 * 写的未免有些脑残了
 * <p>
 * 滑动窗口的实现
 */
@Slf4j
class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        final ContainsNearbyDuplicate duplicate = new ContainsNearbyDuplicate();
        final boolean res = duplicate.containsNearbyDuplicateHd(new int[]{1, 2, 3, 1, 2, 3}, 2);
        log.info("res : {} ", res);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            map.compute(nums[i], (key, v) -> {
                if (v != null) {
                    v.add(finalI);
                } else {
                    v = new ArrayList<>();
                    v.add(finalI);
                }
                return v;
            });
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            final List<Integer> list = entry.getValue();
            if (list.size() > 1) {
                Collections.sort(list);
                for (int i = 1, listSize = list.size(); i < listSize; i++) {
                    if (list.get(i) - list.get(i - 1) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateHd(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}