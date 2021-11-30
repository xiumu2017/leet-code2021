package com.example.code2021.structure.nov;

class FindNthDigit {
    public int findNthDigit(int n) {
        int d = 1;
        int count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1d);
        int num = start + index / d;
        int digitIndex = index % d;
        return (num / (int) (Math.pow(10, d - digitIndex - 1d))) % 10;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/nth-digit/solution/di-n-wei-shu-zi-by-leetcode-solution-mdl2/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。