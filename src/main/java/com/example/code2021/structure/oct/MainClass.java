package com.example.code2021.structure.oct;

import java.util.List;

/**
 * MainClass
 *
 * @author Paradise
 * @date 2021/10/22 10:10
 **/
public class MainClass {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 3, 4, 5, 6, 4, 7, 1, 2, 4, 4, 5, 4, 4, 4, 4, 4,};
        final List<Integer> list = testN229MajorityElementII(nums);
        list.forEach(System.out::println);
    }

    public static List<Integer> testN229MajorityElementII(int[] nums) {
        final N229MajorityElementII elementII = new N229MajorityElementII();
        return elementII.majorityElement(nums);
    }
}
