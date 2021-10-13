package com.example.code2021.structure.sep;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class N141LinkedListCycle {
    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode cur = root;
        for (int i = 0; i < 5; i++) {
            cur.next = new ListNode(i + 1);
            cur = cur.next;
        }
        printListNode(root);

        System.out.println(hasCycle(root));

        ListNode cNode = new ListNode(0);
        ListNode curr = cNode;
        ListNode center = null;
        ListNode tail;
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                center = new ListNode(i + 1);
                curr.next = center;
                curr = curr.next;
                continue;
            }
            curr.next = new ListNode(i + 1);
            curr = curr.next;
            if (i == 4) {
                tail = curr;
                tail.next = center;
            }
        }

        printListNode(cNode);
        System.out.println(hasCycle(cNode));

    }

    // 快慢指针

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast;
        if (head != null && head.next != null) {
            fast = head.next;
        } else {
            return false;
        }
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void printListNode(ListNode root) {
        System.out.println("---------------------------");
        ListNode node = root;
        int limit = 20;
        while (node != null && limit > 0) {
            if (node.next == null) {
                System.out.println(node.val);
            } else {
                System.out.print(node.val + "->");
            }
            node = node.next;
            limit--;
        }
        System.out.println("---------------------------");
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
