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
class FindTilt {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        final TreeNode l1 = new TreeNode(2);
        final TreeNode r1 = new TreeNode(3);
        root.right = r1;
        root.left = l1;
        r1.left = new TreeNode(4);
        r1.right = new TreeNode(5);
        System.out.println(new FindTilt().sum(root));
        System.out.println(new FindTilt().findTilt(root));

    }

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = Math.abs(sum(root.left) - sum(root.right));
        ans += findTilt(root.left);
        ans += findTilt(root.right);
        return ans;
    }

    public int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        if (node.left != null) {
            sum += sum(node.left);
        }
        if (node.right != null) {
            sum += sum(node.right);
        }
        sum += node.val;
        return sum;
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