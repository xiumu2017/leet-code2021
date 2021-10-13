package com.example.code2021.structure.sep;

import java.util.Random;

public class N470Rand10 {
    public static void main(String[] args) {

        System.out.println(rand7());
        System.out.println(rand7());
        System.out.println(rand7());

        System.out.println("---------------------");

        for (int i = 0; i < 10; i++) {
            System.out.println(rand10());
        }
    }

    public static int rand10() {
        int row;
        int col;
        int idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    public static int rand7() {
        return new Random().nextInt(7);
    }
}

//        作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/yong-rand7-shi-xian-rand10-by-leetcode-s-qbmd/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
