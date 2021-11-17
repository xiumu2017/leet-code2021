package com.example.code2021.structure.nov;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * MaxProduct
 *
 * @author Paradise
 * @date 2021/11/17 16:09
 **/
public class MaxProduct {
    public static void main(String[] args) {
        int mask = 0;
        String s = "hello";
        for (int i = 0; i < s.length(); i++) {
            final int c = s.charAt(i) - 'a';
            System.out.println(c);
            final int i1 = 1 << c;
            System.out.println(Integer.toBinaryString(i1));
            mask |= i1;
            System.out.println(Integer.toBinaryString(mask));
            System.out.println(mask);
            System.out.println("---");
        }
        System.out.println(mask);

//        final MaxProduct maxProduct = new MaxProduct();
//        final int product = maxProduct.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
//        System.out.println("pro:" + product);
    }

    public int maxProduct(String[] words) {
        int ans = 0;
        for (String word : words) {
            for (String s : words) {
                if (word.equals(s)) {
                    continue;
                }
                if (!hasSameChar(word, s)) {
                    ans = Math.max(ans, word.length() * s.length());
                }
            }
        }
        return ans;
    }

    private boolean hasSameChar(String s1, String s2) {
        for (char c : s1.toCharArray()) {
            for (char c1 : s2.toCharArray()) {
                if (c1 == c) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : words) {
            int mask = 0;
            int wordLength = s.length();
            for (int j = 0; j < wordLength; j++) {
                mask |= 1 << (s.charAt(j) - 'a');
            }
            if (wordLength > map.getOrDefault(mask, 0)) {
                map.put(mask, wordLength);
            }
        }
        int maxProd = 0;
        Set<Integer> maskSet = map.keySet();
        for (int mask1 : maskSet) {
            int wordLength1 = map.get(mask1);
            for (int mask2 : maskSet) {
                if ((mask1 & mask2) == 0) {
                    int wordLength2 = map.get(mask2);
                    maxProd = Math.max(maxProd, wordLength1 * wordLength2);
                }
            }
        }
        return maxProd;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths/solution/zui-da-dan-ci-chang-du-cheng-ji-by-leetc-lym9/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。