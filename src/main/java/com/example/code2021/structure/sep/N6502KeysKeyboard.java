package com.example.code2021.structure.sep;

class N6502KeysKeyboard {
    public static void main(String[] args) {
        System.out.println(new N6502KeysKeyboard().minSteps(8));
        System.out.println(new N6502KeysKeyboard().minSteps(7));
        System.out.println(new N6502KeysKeyboard().minSteps(6));
        System.out.println(new N6502KeysKeyboard().minSteps(5));
        System.out.println(new N6502KeysKeyboard().minSteps(4));
        System.out.println(new N6502KeysKeyboard().minSteps(3));
    }

    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }
        return ans;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/2-keys-keyboard/solution/zhi-you-liang-ge-jian-de-jian-pan-by-lee-ussa/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。