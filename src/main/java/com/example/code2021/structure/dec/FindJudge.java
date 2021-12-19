package com.example.code2021.structure.dec;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FindJudge {
    public static void main(String[] args) {
//        4
//[[1,3],[1,4],[2,3],[2,4],[4,3]]
    }

    public int findJudge(int n, int[][] trust) {
        Map<Integer, Set<Integer>> t = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] arr : trust) {
            int x = arr[0];
            int y = arr[1];
            if (t.get(x) != null) {
                t.get(x).add(y);
            } else {
                HashSet<Integer> hashSet = new HashSet<>();
                hashSet.add(y);
                t.put(x, hashSet);
            }
            set.add(y);
        }
        for (Integer m : set) {
            if (t.get(m) == null) {
                boolean r = true;
                for (int i = 1; i <= n; i++) {
                    if (i == m) {
                        continue;
                    }
                    if (t.get(i) == null || !t.get(i).contains(m)) {
                        r = false;
                        break;
                    }
                }
                if (r) {
                    return m;
                }
            }
        }
        return -1;
    }

    /**
     * 计算节点的初度和入度
     *
     * @param n     节点数量
     * @param trust 边
     * @return 法官
     */
    public int findJudge2(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] arr : trust) {
            int x = arr[0];
            int y = arr[1];
            out[x]++;
            in[y]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}