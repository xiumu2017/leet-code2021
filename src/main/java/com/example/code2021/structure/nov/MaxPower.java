package com.example.code2021.structure.nov;

/**
 * MaxPower
 *
 * @author Paradise
 * @date 2021/12/1 10:12
 **/
public class MaxPower {
    public static void main(String[] args) {
        System.out.println(new MaxPower().maxPower("leeetcoodddeeee"));
    }

    public int maxPower(String s) {
        int ans = 1;
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr += 1;
                if (i == s.length() - 1) {
                    return Math.max(curr, ans);
                }
            } else {
                ans = Math.max(curr, ans);
                curr = 1;
            }
        }
        return ans;
    }
}
