package com.example.code2021.structure.sep;

/**
 * N326PowerOfThree
 *
 * @author Paradise
 * @date 2021/9/23 08:51
 **/
public class N326PowerOfThree {
    public static void main(String[] args) {

        final N326PowerOfThree n326PowerOfThree = new N326PowerOfThree();
        int[] tests = new int[]{1, 15, 27};
        for (int i : tests) {
            System.out.println(n326PowerOfThree.isPowerOfThree2(i));
            System.out.println(n326PowerOfThree.isPowerOfThree3(i));
            System.out.println();
        }
    }

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 3 || n == 1) {
            return true;
        }
        if (n % 3 == 0) {
            return isPowerOfThree(n / 3);
        }
        return false;
    }

    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfThree3(int n) {
        int x = 1;
        while (x <= n) {
            if (x == n) {
                return true;
            }
            x = x * 3;
        }
        return false;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode-solution-hnap/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
