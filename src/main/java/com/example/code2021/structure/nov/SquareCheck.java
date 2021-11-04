package com.example.code2021.structure.nov;

public class SquareCheck {
    public static void main(String[] args) {

        SquareCheck check = new SquareCheck();
        System.out.println(check.isPerfectSquare(5));
        System.out.println(check.isPerfectSquare(16));
    }

    public boolean isPerfectSquare1(int num) {
        double sqrt = Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public boolean isPerfectSquare2(int num) {
        for (int i = 0; i < num; i++) {
            if (i * i == num) {
                return true;
            }
            if (i * i > num) {
                return false;
            }
        }
        return false;
    }

    public boolean isPerfectSquare3(int num) {
        int left = 0;
        int right = num;
        // 防止溢出
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                right = mid + 1;
            } else {
                left = mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isPerfectSquare4(int num) {
        double x0 = num;
        while (true) {
            double x1 = (x0 + num / x0) / 2;
            if (x0 - x1 < 1e-6) {
                break;
            }
            x0 = x1;
        }
        int x = (int) x0;
        return x * x == num;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/valid-perfect-square/solution/you-xiao-de-wan-quan-ping-fang-shu-by-le-wkee/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}
