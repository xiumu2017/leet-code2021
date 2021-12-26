package com.example.code2021.structure.dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindOcurrences {
    public static void main(String[] args) {
        final String[] ocurrences = new FindOcurrences().findOcurrences("i am a boy and i am good", "i", "am");
        System.out.println(Arrays.toString(ocurrences));
    }

    public String[] findOcurrences(String text, String first, String second) {
        List<String> ans = new ArrayList<>();
        final String[] arr = text.split(" ");
        for (int i = 1; i < arr.length - 1; i++) {
            if (first.equals(arr[i - 1]) && second.equals(arr[i])) {
                ans.add(arr[i + 1]);
            }
        }
        return ans.toArray(new String[]{});
    }
}