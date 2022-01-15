package com.example.code2022.jan;

/**
 * 简单题
 * 2022-1-15
 * 等差数列的求和公式
 * 做个简单题都这么费劲啊~
 */
class TotalMoney {
    public static void main(String[] args) {
        System.out.println(new TotalMoney().totalMoney(7));
        System.out.println(new TotalMoney().totalMoney(14));
        System.out.println(new TotalMoney().totalMoney(4));
        System.out.println(new TotalMoney().totalMoney(10));
        System.out.println(new TotalMoney().totalMoney(20));
    }

    public int totalMoney(int n) {

        int ans = 0;
        final int mod = (n) / 7;
        final int y = n % 7;

        ans += (56 + 7 * (mod - 1)) * mod / 2;
        if (y > 0) {
            final int s = mod + 1;
            ans += (s * 2 + (y - 1)) * y / 2;
        }
        return ans;
    }
}