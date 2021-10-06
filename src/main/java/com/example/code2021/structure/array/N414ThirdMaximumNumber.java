package com.example.code2021.structure.array;

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/third-maximum-number/solution/di-san-da-de-shu-by-leetcode-solution-h3sp/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class N414ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] arrays = new int[]{3, 2, 1, 0, -1};
        System.out.println(thirdMax(arrays));
    }

    public static int thirdMax(int[] nums) {
        // 最大值
        long a = Long.MIN_VALUE;
        // 次大值
        long b = Long.MIN_VALUE;
        // 目标值
        long c = Long.MIN_VALUE;
        // 遍历处理
        for (long num : nums) {
            // 替换最大值
            if (num > a) {
                c = b;
                b = a;
                a = num;
                // 替换次大值
            } else if (a > num && num > b) {
                c = b;
                b = num;
                // 替换目标值
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }
}
