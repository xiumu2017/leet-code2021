package com.example.code2021.structure.dec;

class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        int max = 2 * a.length() + b.length();
        while (sb.length() < max) {
            sb.append(a);
            ans++;
            if (sb.toString().contains(b)) {
                return ans;
            }
        }
        return -1;
    }
}