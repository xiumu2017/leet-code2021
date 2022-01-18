package com.example.code2022.jan;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 中等题
 * 2022-1-18
 */
@Slf4j
class FindMinDifference {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("23:59", "01:22", "03:00", "04:00"));
        final int difference = new FindMinDifference().findMinDifference(list);
        log.info("difference : {} ", difference);
    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        Collections.sort(timePoints);
        int min = 24 * 60;
        for (int i = 1, timePointsSize = timePoints.size(); i < timePointsSize; i++) {
            String timePoint = timePoints.get(i);
            min = Math.min(min, diff(timePoints.get(i - 1), timePoint));
        }
        // 首尾时间差
        min = Math.min(min, diff(timePoints.get(0), timePoints.get(timePoints.size() - 1)));
        return min;
    }

//    timePoints = ["00:00","23:59","00:00"]

    private int diff(String t1, String t2) {
        final String[] s1 = t1.split(":");
        final String[] s2 = t2.split(":");
        int x = Integer.parseInt(s1[0]) * 60 + Integer.parseInt(s1[1]);
        int y = Integer.parseInt(s2[0]) * 60 + Integer.parseInt(s2[1]);
        final int abs = Math.abs(x - y);
        if (abs > 12 * 60) {
            return 24 * 60 - abs;
        }
        return abs;
    }
}