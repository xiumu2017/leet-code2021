package com.example.code2022.jan;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-1-8 格雷码
 * https://leetcode-cn.com/problems/gray-code/
 * 对称生成
 */
class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(ret.get(j) | (1 << (i - 1)));
            }
        }
        return ret;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/gray-code/solution/ge-lei-bian-ma-by-leetcode-solution-cqi7/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。