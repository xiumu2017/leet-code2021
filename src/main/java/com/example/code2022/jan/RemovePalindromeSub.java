package com.example.code2022.jan;

/**
 * 简单题
 * 2022-1-22
 * 这题目完全误导人啊
 */
class RemovePalindromeSub {
    public int removePalindromeSub(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; ++i) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return 2;
            }
        }
        return 1;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/remove-palindromic-subsequences/solution/shan-chu-hui-wen-zi-xu-lie-by-leetcode-s-tqtb/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。