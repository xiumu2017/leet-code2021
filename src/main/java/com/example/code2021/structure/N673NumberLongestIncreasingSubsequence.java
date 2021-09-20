package com.example.code2021.structure;

public class N673NumberLongestIncreasingSubsequence {
    public static void main(String[] args) {
        final N673NumberLongestIncreasingSubsequence subsequence = new N673NumberLongestIncreasingSubsequence();

        System.out.println(subsequence.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int ans = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        // 重置计数
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                // 重置计数
                ans = cnt[i];
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/zui-chang-di-zeng-zi-xu-lie-de-ge-shu-by-w12f/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。