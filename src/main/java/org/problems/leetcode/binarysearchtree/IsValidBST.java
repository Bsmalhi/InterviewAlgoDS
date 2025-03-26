package org.problems.leetcode.binarysearchtree;

public class IsValidBST {
    public static boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(root.left != null && root.val <= root.left.val)
            return false;
        if(root.right != null && root.val >= root.right.val)
            return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println("Is Valid BST?  " + isValidBST(root));
    }
}
