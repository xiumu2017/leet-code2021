package com.example.code2022.jan;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class IsAdditiveNumber {
    public static void main(String[] args) {
        boolean additiveNumber = new IsAdditiveNumber().isAdditiveNumber("");
        log.info("additiveNumber : {} ", additiveNumber);
    }

    public boolean isAdditiveNumber(String num) {
        int length = num.length();


        return false;
    }

    public String add(String s1, String s2) {
        return s1 + s2;
    }
}