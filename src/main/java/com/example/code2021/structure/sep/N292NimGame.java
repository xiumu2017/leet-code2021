package com.example.code2021.structure.sep;

public class N292NimGame {
    public static void main(String[] args) {

        System.out.println(new N292NimGame().canWinNim(15));
        System.out.println(new N292NimGame().canWinNim(16));
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
