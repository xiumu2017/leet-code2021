package com.example.code2021.structure.dec;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class IsNStraightHand {
    public static void main(String[] args) {

    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        final int length = hand.length;
        if (length % groupSize != 0) {
            return false;
        }
        // 排序
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        for (int h : hand) {
            if (!map.containsKey(h)) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                final int key = h + i;
                if (!map.containsKey(key)) {
                    return false;
                }
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            }
        }
        return true;
    }
}