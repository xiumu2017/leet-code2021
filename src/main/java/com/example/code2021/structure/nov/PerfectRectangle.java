package com.example.code2021.structure.nov;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class PerfectRectangle {


    public static void main(String[] args) {
        final PerfectRectangle rectangle = new PerfectRectangle();
        final boolean cover = rectangle.isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}});
        System.out.println(cover);
    }

    public boolean isRectangleCover(int[][] rectangles) {
        // 顶点集合 哈希表
        Set<Point> pointSet = new HashSet<>();
        // 小矩形面积总和
        int area = 0;

        // 初始化 完美矩形的顶点最大最小值
        int left = Integer.MAX_VALUE;
        int bottom = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;

        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0];
            int x2 = rectangle[2];
            int y1 = rectangle[1];
            int y2 = rectangle[3];

            left = Math.min(left, x1);
            right = Math.max(right, x2);
            bottom = Math.min(bottom, y1);
            top = Math.max(top, y2);

            final Point p1 = new Point(x1, y1);
            final Point p2 = new Point(x1, y2);
            final Point p3 = new Point(x2, y1);
            final Point p4 = new Point(x2, y2);
            this.set(pointSet, p1, p2, p3, p4);
            area += (x2 - x1) * (y2 - y1);
        }


        if (pointSet.size() == 4 && pointSet.contains(new Point(left, bottom)) &&
                pointSet.contains(new Point(left, top)) &&
                pointSet.contains(new Point(right, bottom)) &&
                pointSet.contains(new Point(right, top))) {

            return area == (right - left) * (top - bottom);
        }

        return false;
    }

    private void set(Set<Point> pointSet, Point... points) {
        for (Point point : points) {
            if (pointSet.contains(point)) {
                pointSet.remove(point);
            } else {
                pointSet.add(point);
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}