package com.example.code2021.structure.sep;

public class N405ConvertNumber2Hexadecimal {

    public static void main(String[] args) {
        N405ConvertNumber2Hexadecimal test = new N405ConvertNumber2Hexadecimal();
        System.out.println("test.toHex(32) = " + test.toHex(32));
        System.out.println("test.toHex(60) = " + test.toHex(60));
        System.out.println("test.toHex(45) = " + test.toHex(45));
        System.out.println("test.toHex(132) = " + test.toHex(132));
        System.out.println("test.toHex(320) = " + test.toHex(320));

    }

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            // 这是什么意思
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/solution/shu-zi-zhuan-huan-wei-shi-liu-jin-zhi-sh-2srt/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
