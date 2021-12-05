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
class Solution1 {
    // 0
    //- 1 2
    // 3 4 5
    //- 6 7 8 9
    // 10 11 12 13 14
    //- 15 16 17 18 19


    public ListNode reverseEvenLengthGroups(ListNode head) {
        int i = 0;
        ListNode t = head.next;
        while (t.next != null){
            if (i == 1){

            }
            t = t.next;
            i++;
        }

        return head;
    }

    // 奇数偶数判断
    private boolean isO(int i){

        return  false;
    }

    public class ListNode {
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