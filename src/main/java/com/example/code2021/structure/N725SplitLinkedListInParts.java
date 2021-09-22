package com.example.code2021.structure;

import com.example.code2021.common.ListNode;

public class N725SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        // 一次遍历 获取链表长度
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        // 分成多少部分
        int quotient = n / k;
        // 余数，前几部分要+1
        int remainder = n % k;

        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            // 当前部分的大小
            int partSize = quotient + (i < remainder ? 1 : 0);
            // 裁剪链表
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/split-linked-list-in-parts/solution/fen-ge-lian-biao-by-leetcode-solution-wevt/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。