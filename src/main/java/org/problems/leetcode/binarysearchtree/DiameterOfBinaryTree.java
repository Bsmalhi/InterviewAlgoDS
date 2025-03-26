package org.problems.leetcode.binarysearchtree;

public class DiameterOfBinaryTree {
    private static int max = 0;
    public static int diameter(TreeNode root){
        if(root == null)
            return 0;
        helper(root);
        return max;
    }

    private static int helper(TreeNode root) {
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("Diameter of the binary tree is " + diameter(root));
    }
}
