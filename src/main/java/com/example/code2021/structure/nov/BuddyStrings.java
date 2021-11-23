package com.example.code2021.structure.nov;

import java.util.HashSet;
import java.util.Set;

class BuddyStrings {
    public static void main(String[] args) {
        System.out.println(new BuddyStrings().buddyStrings("hello", "hello"));
    }

    public boolean buddyStrings(String s, String goal) {
        final int length = s.length();
        if (length != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            return set.size() < s.length();
        }
        int c = 0;
        char x = 0;
        char y = 0;
        char m = 0;
        char n = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                c++;
                if (c > 2) {
                    return false;
                }
                if (c == 1) {
                    x = s.charAt(i);
                    y = goal.charAt(i);
                }
                if (c == 2) {
                    m = s.charAt(i);
                    n = goal.charAt(i);
                }
            }
        }
        return c == 2 && x == n && y == m;
    }
}