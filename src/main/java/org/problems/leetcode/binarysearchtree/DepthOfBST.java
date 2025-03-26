package org.problems.leetcode.binarysearchtree;

import com.sun.source.tree.Tree;

public class DepthOfBST {
    public static int depth(TreeNode root){
        if(root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.insert(root, 4);
        root.insert(root, 3);
        root.insert(root, 6);
        System.out.println("Depth of a tree is " + depth(root));
    }
}
