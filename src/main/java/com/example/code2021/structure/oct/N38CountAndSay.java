package com.example.code2021.structure.oct;

/**
 * N38CountAndSay
 *
 * @author Paradise
 * @date 2021/10/15 08:57
 **/
public class N38CountAndSay {
    public static void main(String[] args) {
        final N38CountAndSay n38CountAndSay = new N38CountAndSay();
        System.out.println("n38CountAndSay.countAndSay(4) = " + n38CountAndSay.countAndSay(4));
    }

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = sayFrom1(s);
        }
        return s;

    }

    public String sayFrom1(String x) {
        StringBuilder s = new StringBuilder();
        final char[] chars = x.toCharArray();
        int count = 1;
        char t = chars[0];
        if (chars.length == 1) {
            return s.append(1).append(t).toString();
        }
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == chars[i - 1]) {
                count++;
            } else {
                s.append(count).append(t);
                count = 1;
                t = c;
            }
        }
        s.append(count).append(t);
        return s.toString();
    }
}
