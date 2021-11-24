package com.example.code2021.structure.nov;

import java.util.HashMap;
import java.util.Map;

class OriginalDigits {
    public static void main(String[] args) {
        final OriginalDigits originalDigits = new OriginalDigits();
        final String s1 = originalDigits.originalDigits("owoztneoer");
        final String s2 = originalDigits.originalDigits("fviefuro");
        System.out.println(s1);
        System.out.println(s2);
    }

    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] arr = new int[10];
        for (char c : s.toCharArray()) {
            map.compute(c, (k, v) -> v == null ? 1 : ++v);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() == 'z') {
                arr[0] = entry.getValue();
                map.computeIfPresent('e', (k, v) -> v - entry.getValue());
                map.computeIfPresent('r', (k, v) -> v - entry.getValue());
                map.computeIfPresent('o', (k, v) -> v - entry.getValue());
            } else if (entry.getKey() == 'w') {
                arr[2] = entry.getValue();
                map.computeIfPresent('t', (k, v) -> v - entry.getValue());
                map.computeIfPresent('o', (k, v) -> v - entry.getValue());
            } else if (entry.getKey() == 'u') {
                arr[4] = entry.getValue();
                map.computeIfPresent('f', (k, v) -> v - entry.getValue());
                map.computeIfPresent('r', (k, v) -> v - entry.getValue());
                map.computeIfPresent('o', (k, v) -> v - entry.getValue());
            } else if (entry.getKey() == 'x') {
                arr[6] = entry.getValue();
                map.computeIfPresent('s', (k, v) -> v - entry.getValue());
                map.computeIfPresent('i', (k, v) -> v - entry.getValue());
            } else if (entry.getKey() == 'g') {
                arr[8] = entry.getValue();
                map.computeIfPresent('e', (k, v) -> v - entry.getValue());
                map.computeIfPresent('i', (k, v) -> v - entry.getValue());
                map.computeIfPresent('h', (k, v) -> v - entry.getValue());
                map.computeIfPresent('t', (k, v) -> v - entry.getValue());
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() == 'o') {
                arr[1] = entry.getValue();
                map.computeIfPresent('e', (k, v) -> v - entry.getValue());
                map.computeIfPresent('n', (k, v) -> v - entry.getValue());
            } else if (entry.getKey() == 't') {
                arr[3] = entry.getValue();
                map.computeIfPresent('h', (k, v) -> v - entry.getValue());
                map.computeIfPresent('r', (k, v) -> v - entry.getValue());
                map.computeIfPresent('e', (k, v) -> v - entry.getValue() * 2);
            } else if (entry.getKey() == 'f') {
                arr[5] = entry.getValue();
                map.computeIfPresent('i', (k, v) -> v - entry.getValue());
                map.computeIfPresent('v', (k, v) -> v - entry.getValue());
                map.computeIfPresent('e', (k, v) -> v - entry.getValue());
            } else if (entry.getKey() == 's') {
                arr[7] = entry.getValue();
                map.computeIfPresent('e', (k, v) -> v - entry.getValue() * 2);
                map.computeIfPresent('v', (k, v) -> v - entry.getValue());
                map.computeIfPresent('n', (k, v) -> v - entry.getValue());
            }
        }
        arr[9] = map.getOrDefault('i', 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(String.valueOf(i).repeat(Math.max(0, arr[i])));
        }
        return sb.toString();

    }
}