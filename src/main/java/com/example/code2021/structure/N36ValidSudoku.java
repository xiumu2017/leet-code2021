package com.example.code2021.structure;

import java.util.HashMap;

public class N36ValidSudoku {
    public static void main(String[] args) {
        char[][] arr =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(new N36ValidSudoku().isValidSudoku(arr));
        System.out.println(new N36ValidSudoku().isValidSudokuPro(arr));
    }

    public boolean isValidSudoku(char[][] board) {
        // 遍历每一行
        for (char[] chars : board) {
            HashMap<Character, Integer> hashMap = new HashMap<>(9);
            for (char c : chars) {
                if (c == '.') {
                    continue;
                }
                if (hashMap.containsKey(c)) {
                    return false;
                }
                hashMap.put(c, 1);
            }
        }
        for (int i = 0; i < 9; i++) {
            HashMap<Character, Integer> hashMap = new HashMap<>(9);
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == '.') {
                    continue;
                }
                if (hashMap.containsKey(c)) {
                    return false;
                }
                hashMap.put(c, 1);
            }
        }
        for (int i = 0; i < 9; i++) {
            HashMap<Character, Integer> hashMap = new HashMap<>(9);
            for (int j = 0; j < 9; j++) {
                int m = i / 3;
                int n = j / 3;
                char c = board[m][n];
                if (c == '.') {
                    continue;
                }
                if (hashMap.containsKey(c)) {
                    return false;
                }
                hashMap.put(c, 1);
            }
        }

        return true;
    }

    public boolean isValidSudokuPro(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/valid-sudoku/solution/you-xiao-de-shu-du-by-leetcode-solution-50m6/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
