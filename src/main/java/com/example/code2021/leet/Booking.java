package com.example.code2021.leet;

/**
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 * 连续数组，差分法的理解
 */
public class Booking {
    public static void main(String[] args) {

        int[][] arrays = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;

        final int[] ans = corpFlightBookings(arrays, n);
        for (int x : ans) {
            System.out.println(x);
        }

    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] arr : bookings) {
            int s = arr[0];
            int e = arr[1];
            for (int i = s; i <= e; i++) {
                ans[i - 1] += arr[2];
            }
        }
        return ans;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/corporate-flight-bookings/solution/hang-ban-yu-ding-tong-ji-by-leetcode-sol-5pv8/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//    差分法

    static class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] nums = new int[n];
            for (int[] booking : bookings) {
                nums[booking[0] - 1] += booking[2];
                if (booking[1] < n) {
                    nums[booking[1]] -= booking[2];
                }
            }
            for (int i = 1; i < n; i++) {
                nums[i] += nums[i - 1];
            }
            return nums;
        }
    }

}
