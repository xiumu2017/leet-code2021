package com.example.code2021.structure.dec;

class IslandPerimeter {
    public static void main(String[] args) {
        final IslandPerimeter perimeter = new IslandPerimeter();
        System.out.println(perimeter.islandPerimeter(new int[][]{{1, 1, 0}}));

    }

    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int x = grid[i][j];
                if (x == 1) {
                    // 判断是否上下左右边界
                    // 判断上下左右的格子是否是 0
                    if (i == 0) {
                        ans += 1;
                    }
                    if (i == grid.length - 1) {
                        ans += 1;
                    }
                    if (j == 0) {
                        ans += 1;
                    }
                    if (j == grid[0].length - 1) {
                        ans += 1;
                    }
                    if (i > 0 && grid[i - 1][j] == 0) {
                        ans += 1;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 0) {
                        ans += 1;
                    }
                    if (j > 0 && grid[i][j - 1] == 0) {
                        ans += 1;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 0) {
                        ans += 1;
                    }
                }
            }
        }
        return ans;
    }
}