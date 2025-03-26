package org.problems.leetcode.binarysearchtree;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInorderPreorderList {
    /*
    So the logic is that preorder gives you the root to start with
    and inorder index gives the position of that root and based on that
    we can choose to have that many nodes in left side and then right side
    */
    private static int preIndex = 0;
    public static TreeNode buildTree(int[] preorder, int [] inorder){
        Map<Object, Object> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1, preorder, inorderMap);
    }

    private static TreeNode helper(int left, int right, int[] preorder, Map<Object, Object> inorderMap) {
        if(left > right)
            return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int mid = (int) inorderMap.get(root.val);
        root.left = helper(left, mid - 1, preorder, inorderMap);
        root.right = helper(mid + 1, right, preorder, inorderMap);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {1,2,3,4};
        int[] inorder = {2,1,3,4};
        System.out.println("Building tree with preorder & inorder list : ");
        TreeNode root = buildTree(preOrder, inorder);
        root.inorderPrint(root);
    }
}
