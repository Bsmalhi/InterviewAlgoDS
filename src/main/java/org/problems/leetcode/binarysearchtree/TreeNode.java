package org.problems.leetcode.binarysearchtree;

public class TreeNode{
    public int val;
    public TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
    }
    /*
        4
       / \
      3   5
    */
    public TreeNode insert(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val < root.val){
            root.left = insert(root.left, val);
        } else if(val > root.val){
            root.right = insert(root.right, val);
        }
        return root;
    }



    public void inorderPrint(TreeNode root){
        if(root == null)
            return;
        inorderPrint(root.left);
        System.out.println(root.val);
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.insert(root, 5);
        root.insert(root, 3);
        root.insert(root, 2);
        root.insert(root, 6);
        root.inorderPrint(root);
    }
}