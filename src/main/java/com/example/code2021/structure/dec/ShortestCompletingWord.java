package com.example.code2021.structure.dec;

import java.util.HashMap;
import java.util.Map;

class ShortestCompletingWord {
    public static void main(String[] args) {

        final ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();
        final String word = shortestCompletingWord.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
        System.out.println(word);

        final String word1 = shortestCompletingWord.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"});
        System.out.println(word1);
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase().replace(" ", "").replaceAll("\\d", "");
        Map<Character, Integer> map = toMap(licensePlate);
        int len = Integer.MAX_VALUE;
        String ans = "";
        for (String word : words) {
            if (word.length() < licensePlate.length()) {
                continue;
            }
            if (isSub(map, word) && word.length() < len) {
                len = word.length();
                ans = word;
            }
        }

        return ans;
    }

    public Map<Character, Integer> toMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.compute(s.charAt(i), (k, v) -> v == null ? 1 : ++v);
        }
        return map;
    }

    public boolean isSub(Map<Character, Integer> map, String word) {
        Map<Character, Integer> cp = toMap(word);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (cp.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}