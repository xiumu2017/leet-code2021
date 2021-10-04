package com.example.code2021.structure;

public class N482LicenseKeyFormatting {
    public static void main(String[] args) {

        N482LicenseKeyFormatting formatting = new N482LicenseKeyFormatting();
        System.out.println(formatting.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(formatting.licenseKeyFormatting("5F3Z-2e-9-w", 3));
    }

    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-", "").toUpperCase();
        int length = s.length();
        if (k > length) {
            return s;
        }
        int x = length % k;
        StringBuilder sb = new StringBuilder();
        if (x > 0) {
            for (int i = 0; i < x; i++) {
                sb.append(s.charAt(i));
            }
            sb.append("-");
        }
        int c = 0;
        for (int i = x; i < length; i++, c++) {
            if (c == k) {
                sb.append("-");
                c = 0;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String licenseKeyFormatting2(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                cnt++;
                ans.append(Character.toUpperCase(s.charAt(i)));
                if (cnt % k == 0) {
                    ans.append("-");
                }
            }
        }
        if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
        }

        return ans.reverse().toString();
    }

}

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/license-key-formatting/solution/mi-yao-ge-shi-hua-by-leetcode-solution-xnae/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
