package com.example.code2021.structure.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * N500KeyboardRow
 *
 * @author Paradise
 * @date 2021/10/31 09:45
 **/
public class N500KeyboardRow {

    private static final Map<Character, Integer> map = new HashMap<>(26);
    private static final Map<Character, Integer> map2 = new HashMap<>(26);

    static {
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);

        char[] arr = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        for (char c : arr) {
            map.put(c, 2);
        }
        char[] arr3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        for (char c : arr3) {
            map.put(c, 3);
        }
        map.forEach((k, v) -> map2.put(Character.toUpperCase(k), v));
        map.putAll(map2);
    }

    public static void main(String[] args) {
        final N500KeyboardRow row = new N500KeyboardRow();
        final String[] words = row.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        for (String word : words) {
            System.out.println(word);
        }
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if ("".equals(word) || check(word)) {
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }

    private boolean check(String word) {
        int index = map.get(word.charAt(0));
        for (char c : word.toCharArray()) {
            if (map.get(c) != index) {
                return false;
            }
        }

        return true;
    }
}
