package com.example.code2021.structure.sep;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/ransom-note/
 */
public class N242ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("a", "ab"));
        System.out.println(isAnagram("aacc", "abcc"));
    }

//    杂志字符串中的每个字符只能在赎金信字符串中使用一次

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> smap = new HashMap<>();
        for (char c : s.toCharArray()) {
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : smap.entrySet()) {
            if (!tmap.containsKey(entry.getKey()) || !tmap.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
