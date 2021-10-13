package com.example.code2021.structure.sep;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/ransom-note/
 */
public class N383RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aqwer", "aqwersdahghs"));
        System.out.println(canConstruct("aqwer", "aqersdahghs"));
    }

//    杂志字符串中的每个字符只能在赎金信字符串中使用一次

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> rMap = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            rMap.put(c, rMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> mMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            mMap.put(c, mMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : rMap.entrySet()) {
            if (!mMap.containsKey(entry.getKey()) || mMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
