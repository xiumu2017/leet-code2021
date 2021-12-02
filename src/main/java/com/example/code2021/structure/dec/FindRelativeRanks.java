package com.example.code2021.structure.dec;

import java.util.Arrays;
import java.util.HashMap;

class FindRelativeRanks {
    public static void main(String[] args) {
        final FindRelativeRanks ranks = new FindRelativeRanks();
        final String[] strings = ranks.findRelativeRanks(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(strings));
    }

    public String[] findRelativeRanks(int[] score) {
        // 排序 哈希表 遍历
        final int[] copy = Arrays.copyOf(score, score.length);
        Arrays.sort(copy);
        HashMap<Integer, String> map = new HashMap<>();
        for (int j = copy.length - 1; j >= 0; j--) {
            int i = copy[j];
            if (j == copy.length - 1) {
                map.put(i, "Gold Medal");
                continue;
            }
            if (j == copy.length - 2) {
                map.put(i, "Silver Medal");
                continue;
            }
            if (j == copy.length - 3) {
                map.put(i, "Bronze Medal");
                continue;
            }
            map.put(i, String.valueOf(copy.length - j));
        }
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            ans[i] = map.get(score[i]);
        }
        return ans;
    }
}