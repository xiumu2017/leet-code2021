package com.example.code2021.structure.nov;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Add2Numbers {
    public static void main(String[] args) {
        final Add2Numbers numbers = new Add2Numbers();
        final ListNode node1 = getNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        final ListNode node2 = getNode(new int[]{9, 9, 9, 9});
        print(node1);
        print(node2);
        final ListNode node = numbers.addTwoNumbers(node1, node2);
        print(node);
    }

    public static ListNode getNode(int[] arr) {
        ListNode[] nodes = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode();
            node.val = arr[i];
            nodes[i] = node;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        return nodes[0];
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ll1 = getLength(l1);
        int ll2 = getLength(l2);
        ListNode ln = ll1 >= ll2 ? l1 : l2;
        ListNode sn = ll1 < ll2 ? l1 : l2;
        ListNode root = ln;
        int x = 0;
        while (ln != null) {
            int sum = ln.val + x;
            if (sn != null) {
                sum = sum + sn.val;
            }
            if (sum > 9) {
                ln.val = sum - 10;
                x = 1;
            } else {
                ln.val = sum;
                x = 0;
            }
            if (sn != null) {
                sn = sn.next;
            }
            if (ln.next == null && x > 0) {
                final ListNode next = new ListNode();
                next.val = 1;
                ln.next = next;
                break;
            }
            ln = ln.next;
        }

        return root;
    }

    public int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
