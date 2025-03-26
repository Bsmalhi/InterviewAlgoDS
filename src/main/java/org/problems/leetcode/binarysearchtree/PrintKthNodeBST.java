package org.problems.leetcode.binarysearchtree;

public class PrintKthNodeBST {
    private static int result = 0;
    private static int count = 0;
    public static int kthNode(TreeNode root, int k){
        if(root == null)
            return 0;
        helper(root, k);
        return result;
    }
    // inorder traversal to get the kth
    private static void helper(TreeNode root, int k){
        if(root == null)
            return;
        helper(root.left, k);
        count++;
        if(k == count){
            result = root.val;
            return;
        }
        helper(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("3rd node in the BST is " + kthNode(root, 3));
    }
}
