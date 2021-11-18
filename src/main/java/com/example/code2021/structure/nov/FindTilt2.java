package com.example.code2021.structure.nov;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class FindTilt2 {
    int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        final TreeNode l1 = new TreeNode(1);
        final TreeNode r1 = new TreeNode(3);
        root.right = r1;
        root.left = l1;
        r1.left = new TreeNode(4);
        r1.right = new TreeNode(5);
        System.out.println(new FindTilt2().sum(root));
        System.out.println(new FindTilt2().findTilt(root));

    }

    public int findTilt(TreeNode root) {
        sum(root);
        return ans;
    }

    public int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sl = sum(node.left);
        int sr = sum(node.right);
        ans += Math.abs(sl - sr);
        return sl + sr + node.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}