package com.example.code2021.structure.dec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

class DayOfYear {
    public static void main(String[] args) {
        System.out.printf("res: %s", new DayOfYear().dayOfYear2("2019-03-09"));
    }

    public int dayOfYear(String date) {
        final String[] split = date.split("-");
        int y = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int d = Integer.parseInt(split[2]);
        return LocalDate.of(y, m, d).getDayOfYear();

    }

    public int dayOfYear2(String date) {
        final Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public int dayOfYear3(String date) {
        final String[] split = date.split("-");
        int y = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]) - 1;
        int ans = Integer.parseInt(split[2]);
        int[] a1 = new int[]{0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        int[] a2 = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        final boolean b = y % 4 == 0;
        if (b) {
            ans += a1[m];
        } else {
            ans += a2[m];
        }
        return ans;
    }
}