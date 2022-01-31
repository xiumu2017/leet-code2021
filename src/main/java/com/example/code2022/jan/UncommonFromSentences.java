package com.example.code2022.jan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String s : arr2) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : arr1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}