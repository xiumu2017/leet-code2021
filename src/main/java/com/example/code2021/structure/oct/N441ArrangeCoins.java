package com.example.code2021.structure.oct;

public class N441ArrangeCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoinsPro(8));
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(1));
        System.out.println(arrangeCoins(2));
    }

    public static int arrangeCoins(int n) {
        int sum = 0;
        int i = 1;
        for (; sum <= n; i++) {
            sum += i;
        }
        return i - 2;
    }

    public static int arrangeCoinsPro(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/arranging-coins/solution/pai-lie-ying-bi-by-leetcode-solution-w52c/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
