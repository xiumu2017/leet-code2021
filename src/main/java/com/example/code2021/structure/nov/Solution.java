package com.example.code2021.structure.nov;

class Solution {
    public static void main(String[] args) {
        String s = new Solution().decodeCiphertext("iveo    eed   l te   olc", 4);
        System.out.println(s);
        System.out.println(new Solution().decodeCiphertext(" b  ac", 2));
    }

    public String decodeCiphertext(String encodedText, int rows) {
        int columns = encodedText.length() / rows;
        char[][] encoded = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                encoded[i][j] = encodedText.charAt(i * columns + j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows && i + j < columns; j++) {
                sb.append(encoded[j][i + j]);
            }
        }
        String ans = sb.toString();
        int c = 0;
        for (int i = sb.length() - 1; i > 0; i--) {
            if (sb.charAt(i) == ' ') {
                c++;
            } else {
                break;
            }
        }
        return ans.substring(0, sb.length() - c);
    }

}