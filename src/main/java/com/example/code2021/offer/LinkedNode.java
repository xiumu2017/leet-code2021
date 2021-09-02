package com.example.code2021.offer;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class LinkedNode {
    public static void main(String[] args) {

        ListNode root = new ListNode(0);
        ListNode cur = root;
        for (int i = 0; i < 5; i++) {
            cur.next = new ListNode(i + 1);
            cur = cur.next;
        }
        ListNode node = root;
        while (node != null) {
            if (node.next == null) {
                System.out.print(node.val);
            } else {
                System.out.print(node.val + "->");
            }
            node = node.next;
        }
        System.out.println();

        ListNode ans = getKthFromEnd(root, 3);
        System.out.println(ans);

        ans = getKthFromEndPro(root, 3);
        System.out.println(ans);
    }

    // 顺序查找
    // 快慢指针

    public static ListNode getKthFromEnd(ListNode head, int k) {
        final int length = length(head);
        for (int i = 0; i < length - k + 1; i++) {
            head = head.next;
        }
        return head;
    }

    public static ListNode getKthFromEndPro(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static int length(ListNode node) {
        int i = 0;
        while (node.next != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "{" +
                    "val=" + val +
                    '}';
        }
    }
}
