package com.example.code2021.structure.dec;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class NumWaterBottles {
    public static void main(String[] args) {
        final NumWaterBottles bottles = new NumWaterBottles();
        final int waterBottles = bottles.numWaterBottles(7, 2);
        log.info("waterBottles = " + waterBottles);
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            numBottles = numBottles - numExchange;
            ans++;
            numBottles++;
        }
        return ans;

    }
}