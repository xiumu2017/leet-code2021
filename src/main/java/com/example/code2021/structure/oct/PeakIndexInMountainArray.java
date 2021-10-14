package com.example.code2021.structure.oct;

/**
 * PeakIndexInMountainArray
 *
 * @author Paradise
 * @date 2021/10/14 19:17
 **/
public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] arr = new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        final int index = new PeakIndexInMountainArray().peakIndexInMountainArray(arr);
        System.out.println(index);
    }

    public int peakIndexInMountainArray(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            } else {
                return i - 1;
            }
        }
        return 0;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int left = 1;
        int right = n - 2;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/B1IidL/solution/shan-feng-shu-zu-de-ding-bu-by-leetcode-9j8lk/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
