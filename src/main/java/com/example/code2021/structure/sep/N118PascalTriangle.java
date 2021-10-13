package com.example.code2021.structure.sep;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class N118PascalTriangle {
    public static void main(String[] args) {

        print(generate(6));

        print(generate(10));
        print(generate(20));

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                lists.add(List.of(1));
                continue;
            }
            if (i == 1) {
                lists.add(List.of(1, 1));
                continue;
            }
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                    continue;
                }
                list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
            }
            lists.add(list);
        }
        return lists;
    }

    public static void print(List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            printBlank(lists.size() - i);
            for (Integer integer : list) {
                System.out.printf("%-6d", integer);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public static void printBlank(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("   ");
        }
    }

}
