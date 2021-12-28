package com.example.code2021.structure.dec;

class NumFriendRequests {
    public static void main(String[] args) {
        System.out.print(Integer.valueOf((int) (0.3 * 3)));
        System.out.print(String.valueOf((int) (0.3 * 4)));
        System.out.print(String.valueOf((int) (0.3 * 6)));
    }

    public int numFriendRequests(int[] ages) {
        // 数组维护 各个年龄 的数量
        int[] cnt = new int[121];
        for (int age : ages) {
            ++cnt[age];
        }
        // 数组维护 前缀和
        int[] pre = new int[121];
        for (int i = 1; i <= 120; ++i) {
            pre[i] = pre[i - 1] + cnt[i];
        }
        int ans = 0;
        for (int i = 15; i <= 120; ++i) {
            if (cnt[i] > 0) {
                // 向下取整
                int bound = (int) (i * 0.5 + 8);
                ans += cnt[i] * (pre[i] - pre[bound - 1] - 1);
            }
        }
        return ans;
    }
}

//作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages/solution/gua-ling-de-peng-you-by-leetcode-solutio-v7yk/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。