package com.example.code2021.structure.nov;

import java.util.HashMap;
import java.util.Map;

/**
 * BullsAndCows
 *
 * @author Paradise
 * @date 2021/11/8 18:04
 **/
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        final int length = secret.length();
        int ca = 0;
        int cb = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ca++;
            } else {
                map1.compute(secret.charAt(i), (k, v) -> v == null ? 1 : ++v);
                map2.compute(guess.charAt(i), (k, v) -> v == null ? 1 : ++v);
            }
        }
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (map1.get(entry.getKey()) != null) {
                cb += Math.min(entry.getValue(), map1.get(entry.getKey()));
            }
        }
        return ca + "A" + cb + "B";
    }

    public String getHintArr(String secret, String guess) {
        final int length = secret.length();
        int ca = 0;
        int cb = 0;
        int[] sa = new int[10];
        int[] ga = new int[10];
        for (int i = 0; i < length; i++) {
            final char sc = secret.charAt(i);
            if (sc == guess.charAt(i)) {
                ca++;
            } else {
                sa[sc - 48] += 1;
                ga[sc - 48] += 1;
            }
        }
        for (int i = 0; i < 10; i++) {
            cb += Math.min(sa[i], ga[i]);
        }
        return ca + "A" + cb + "B";
    }
}
