package com.example.code2021.structure.dec;

import java.util.ArrayList;
import java.util.List;

class ColorBorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        // 存储边界
        List<int[]> borders = new ArrayList<>();
        // 原始颜色
        int originalColor = grid[row][col];
        // 存储已遍历的点
        visited[row][col] = true;
        // 深度优先搜索
        dfs(grid, row, col, visited, borders, originalColor);
        // 边界上色
        for (int[] border : borders) {
            grid[border[0]][border[1]] = color;
        }
        return grid;
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited, List<int[]> borders, int originalColor) {
        int m = grid.length;
        int n = grid[0].length;
        boolean isBorder = false;
        // 表示 xy 坐标的四种变化
        int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // 上下左右四个相邻点
        for (int i = 0; i < 4; i++) {
            int nx = direc[i][0] + x;
            int ny = direc[i][1] + y;
            // 不连通 = 边界
            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == originalColor)) {
                isBorder = true;
                // 联通 且 未被访问
            } else if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(grid, nx, ny, visited, borders, originalColor);
            }
        }
        if (isBorder) {
            borders.add(new int[]{x, y});
        }
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/coloring-a-border/solution/bian-kuang-zhao-se-by-leetcode-solution-0h5l/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。