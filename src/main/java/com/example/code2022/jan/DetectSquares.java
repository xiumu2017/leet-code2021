package com.example.code2022.jan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DetectSquares {

    private final Map<Integer, List<Point>> xMap = new HashMap<>();
    private final Map<Integer, List<Point>> yMap = new HashMap<>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        xMap.compute(point[0], (k, v) -> {
            if (v == null) {
                List<Point> list = new ArrayList<>();
                list.add(new Point(point));
                return list;
            } else {
                v.add(new Point(point));
                return v;
            }
        });
        yMap.compute(point[1], (k, v) -> {
            if (v == null) {
                List<Point> list = new ArrayList<>();
                list.add(new Point(point));
                return list;
            } else {
                v.add(new Point(point));
                return v;
            }
        });
    }

    public int count(int[] point) {
        int x = point[0];
        final int y = point[1];
        if (xMap.get(x) == null || !yMap.containsKey(y)) {
            return 0;
        }
        // 纵轴 节点
        int ans = 0;
        final List<Point> list = xMap.get(x);
        if (list != null) {
            for (Point yp : list) {
                // 横轴
                final List<Point> list1 = yMap.get(yp.getY());
                if (list1 != null) {
                    for (Point point1 : list1) {

                    }
                }
            }
        }
        return 1;
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int[] p) {
            this.x = p[0];
            this.y = p[1];
        }


        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */