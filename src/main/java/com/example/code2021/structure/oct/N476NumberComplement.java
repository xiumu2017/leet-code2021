package com.example.code2021.structure.oct;

/**
 * N476NumberComplement
 *
 * @author Paradise
 * @date 2021/10/18 16:34
 **/
public class N476NumberComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(27));
    }

    public static int findComplement(int num) {
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }
}
