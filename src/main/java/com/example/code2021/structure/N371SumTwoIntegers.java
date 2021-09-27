package com.example.code2021.structure;

class N371SumTwoIntegers {
    public static void main(String[] args) {
        final N371SumTwoIntegers n371SumTwoIntegers = new N371SumTwoIntegers();
        System.out.println(n371SumTwoIntegers.getSum(3, 14));
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/sum-of-two-integers/solution/liang-zheng-shu-zhi-he-by-leetcode-solut-c1s3/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。