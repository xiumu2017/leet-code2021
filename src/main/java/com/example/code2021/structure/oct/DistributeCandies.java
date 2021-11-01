package com.example.code2021.structure.oct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 哈希表
 * DistributeCandies
 *
 * @author Paradise
 * @date 2021/11/1 18:59
 **/
public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : candyType) {
            map.computeIfPresent(i, (k, v) -> ++v);
            map.putIfAbsent(i, 1);
        }
        int s = map.size();
        if (s >= candyType.length / 2) {
            return candyType.length / 2;
        }
        return s;
    }

    public int distributeCandies2(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        int s = set.size();
        return Math.min(s, candyType.length / 2);
    }
}
