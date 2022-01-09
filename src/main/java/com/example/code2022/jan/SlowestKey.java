package com.example.code2022.jan;

/**
 * 简单题
 * <a href="https://leetcode-cn.com/problems/slowest-key/">LeetCode</a>
 * 2022-1-9
 * <p>
 * 请返回按键 持续时间最长 的键，如果有多个这样的键，则返回 按字母顺序排列最大 的那个键。
 * 可恶
 */
class SlowestKey {
    public static void main(String[] args) {
        System.out.printf("res: %s", new SlowestKey().slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));
        System.out.println();
        System.out.printf("res: %s", new SlowestKey().slowestKey(new int[]{1, 2}, "ba"));
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char res = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            final int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > max) {
                max = time;
                res = keysPressed.charAt(i);
            }
            if (time == max && keysPressed.charAt(i) > res) {
                res = keysPressed.charAt(i);
            }
        }
        return res;
    }
}