package com.example.code2021.structure.oct;

import java.util.HashSet;
import java.util.Set;

/**
 * N869ReorderedPower2
 *
 * @author Paradise
 * @date 2021/10/28 13:47
 **/
public class N869ReorderedPower2 {

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));
        System.out.println(reorderedPowerOf2(46));
        System.out.println(reorderedPowerOf2(31));
    }

    public static boolean reorderedPowerOf2(int n) {
        Set<String> set = new HashSet<>();
        set.add(numberToStr(1));
        for (int i = 0; i <= 29; i++) {
            int pow = 2 << i;
            set.add(numberToStr(pow));
        }
        set.forEach(System.out::println);

        return set.contains(numberToStr(n));
    }

    private static String numberToStr(int n) {
        int[] ans = new int[10];
        for (char c : String.valueOf(n).toCharArray()) {
            int x = c - 48;
            ++ans[x];
        }
        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an);
        }
        return sb.toString();
    }
}
