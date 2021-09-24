package com.example.code2021.structure;

import lombok.Getter;

/**
 * N430FlattenLinkedList
 *
 * @author Paradise
 * @date 2021/9/24 09:12
 **/
public class N430FlattenLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;

        node3.child = node7;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;

        node8.child = node11;
        node11.next = node12;
        node12.prev = node11;

        printNode(node1);

        final N430FlattenLinkedList n430FlattenLinkedList = new N430FlattenLinkedList();
        n430FlattenLinkedList.dfs(node1);
        printNode(node1);
    }

    public static void printNode(Node node1) {
        System.out.println("");
        Node x = node1;
        while (x != null) {
            System.out.print(x.getVal());
            System.out.print("-->");
            if (x.child != null) {
                printNode(x.child);
            }
            x = x.next;
        }
        System.out.println("");
    }

    // 子 接在 父后面，递归
    public Node flatten(Node head) {
        Node curr = head;
        while (curr.child != null) {
            curr.child.prev = curr;
            curr.next = flatten(curr.child, curr.next);
            curr = curr.next;
        }
        return head;
    }

    public Node flatten(Node head, Node next) {
        Node curr;
        if (head.child != null) {
            head.next = flatten(head.child, next);
            head.child = null;
        } else {
            curr = head.next;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = next;
            next.prev = curr;
        }
        return head;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/solution/bian-ping-hua-duo-ji-shuang-xiang-lian-b-383h/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public Node dfs(Node node) {
        Node cur = node;
        // 记录链表的最后一个节点
        Node last = null;
        while (cur != null) {
            Node next = cur.next;
            //  如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node childLast = dfs(cur.child);

                next = cur.next;
                //  将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;

                //  如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                // 将 child 置为空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }

    static class Node {
        @Getter
        private final int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }
}
