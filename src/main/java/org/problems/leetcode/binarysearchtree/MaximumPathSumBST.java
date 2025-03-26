package org.problems.leetcode.binarysearchtree;

public class MaximumPathSumBST {
    private static int max = Integer.MIN_VALUE;
    public static int pathSum(TreeNode root){
        if(root == null)
            return 0;
        helper(root);
        return max;
    }
    private static int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = Math.max(helper(root.left), 0); // ignore -ve values from left subtree
        int right = Math.max(helper(root.right), 0); // ignore -ve values from right subtree
        max = Math.max(max, root.val + left + right);
        // as we want to get the max path we split left & right
        // When recursing upward, we can’t return both branches
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("Maximum path sum of BST is " + pathSum(root));
    }
}
