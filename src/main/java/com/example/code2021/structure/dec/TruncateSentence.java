package com.example.code2021.structure.dec;

class TruncateSentence {
    public static void main(String[] args) {
        final String sentence = new TruncateSentence().truncateSentence("Hello word my bady", 5);
        System.out.println(sentence);
    }

    public String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && --k == 0) {
                return s.substring(0, i);
            }
        }
        return s;
    }
}