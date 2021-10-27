package com.example.code2021.structure.oct;

/**
 * ByteCode
 *
 * @author Paradise
 * @date 2021/10/27 16:53
 **/
public class ByteCode {
    public static void main(String[] args) {
        int i = 0;
        int x = i++;
        System.out.println(i);
        System.out.println(x);
        int y = ++i;
        System.out.println(y);
        System.out.println(i);
    }
}
