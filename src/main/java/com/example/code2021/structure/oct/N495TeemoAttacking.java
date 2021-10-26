package com.example.code2021.structure.oct;

/**
 * N495TeemoAttacking
 *
 * @author Paradise
 * @date 2021/10/26 19:20
 **/
public class N495TeemoAttacking {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4};
        System.out.println(findPoisonedDuration(arr, 2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            final int dur = timeSeries[i] - timeSeries[i - 1];
            ans += Math.min(dur, duration);
        }
        return ans + duration;
    }
}
