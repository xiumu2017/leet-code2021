package com.example.code2021.structure.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N412FizzBuzz
 *
 * @author Paradise
 * @date 2021/10/13 09:16
 **/
public class N412FizzBuzz {
    public static void main(String[] args) {
        N412FizzBuzz o = new N412FizzBuzz();
        final List<String> list = o.fizzBuzz(15);
        System.out.println("list.toArray() = " + Arrays.toString(list.toArray()));
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
