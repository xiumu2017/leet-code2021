package com.example.code2021.structure.nov;

import java.util.HashMap;
import java.util.Map;

class LongestSubsequence {

    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + difference == arr[i + 1]) {
                count = count + 1;
            } else {
                ans = Math.max(count, ans);
            }
        }
        return ans;
    }

    public int longestSubsequenceDp(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/solution/zui-chang-ding-chai-zi-xu-lie-by-leetcod-xkua/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
