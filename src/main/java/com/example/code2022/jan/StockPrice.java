package com.example.code2022.jan;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class StockPrice {

    // 保存  时间戳 和 价格
    private final Map<Integer, Integer> map;
    // 保存 价格 和 出现的次数
    private final TreeMap<Integer, Integer> set;
    // 当前时间戳
    private int current = 0;

    public StockPrice() {
        map = new HashMap<>();
        set = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (timestamp > current) {
            current = timestamp;
        }
        // 更新价格出现次数
        if (map.containsKey(timestamp)) {
            final Integer oldPrice = map.get(timestamp);
            final Integer val = set.get(oldPrice);
            if (val == 1) {
                set.remove(oldPrice);
            } else {
                set.put(oldPrice, val - 1);
            }
        }
        set.put(price, set.getOrDefault(price, 0) + 1);
        map.put(timestamp, price);

    }

    public int current() {
        return map.get(current);
    }

    public int maximum() {
        return set.lastKey();
    }

    public int minimum() {
        return set.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */