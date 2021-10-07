package com.example.code2021.structure.string;

/**
 * N434NumbeOfSegmentsString
 *
 * @author Paradise
 * @date 2021/10/7 18:51
 **/
public class N434NumbeOfSegmentsString {
    public static void main(String[] args) {

        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(countSegments("Hello, my name is John L L"));
    }

    public static int countSegments(String s) {
        if ("".equals(s)) {
            return 0;
        }
        return s.split(" ").length;
    }

    public static int countSegmentsPro(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string/solution/zi-fu-chuan-zhong-de-dan-ci-shu-by-leetc-igfb/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
