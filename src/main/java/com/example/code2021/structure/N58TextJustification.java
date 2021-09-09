package com.example.code2021.structure;

import java.util.ArrayList;
import java.util.List;

class N58TextJustification {
    public static void main(String[] args) {

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int right = 0, n = words.length;
        while (true) {
            int left = right; // 当前行的第一个单词在 words 的位置
            int sumLen = 0; // 统计这一行单词长度之和
            // 循环确定当前行可以放多少单词，注意单词之间应至少有一个空格
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }

            // 当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格
            if (right == n) {
                StringBuffer sb = join(words, left, n, " ");
                sb.append(blank(maxWidth - sb.length()));
                ans.add(sb.toString());
                return ans;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            // 当前行只有一个单词：该单词左对齐，在行末填充剩余空格
            if (numWords == 1) {
                ans.add(words[left] + blank(numSpaces));
                continue;
            }

            // 当前行不只一个单词
            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);
            String sb = join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1)) + // 拼接额外加一个空格的单词
                    blank(avgSpaces) +
                    join(words, left + extraSpaces + 1, right, blank(avgSpaces)); // 拼接其余单词
            ans.add(sb);
        }
    }

    // blank 返回长度为 n 的由空格组成的字符串
    public static String blank(int n) {
        return " ".repeat(Math.max(0, n));
    }

    // join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
    public static StringBuffer join(String[] words, int left, int right, String sep) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; ++i) {
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/text-justification/solution/wen-ben-zuo-you-dui-qi-by-leetcode-solut-dyeg/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。