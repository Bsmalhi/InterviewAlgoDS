package org.problems.leetcode.binarysearchtree;

public class CountGoodNodes {
    private static int count = 0;
    private static int goodNodesCount(TreeNode root){
        if(root == null)
            return 0;
        helper(root, root.val);
        return count;
    }
    private static void helper(TreeNode root, int max){
        if(root == null)
            return;
        max = Math.max(max, root.val);
        if(root.val >= max){
            count += 1;
        }
        helper(root.left, max);
        helper(root.right, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Count of good nodes: " + goodNodesCount(root));
    }
}
