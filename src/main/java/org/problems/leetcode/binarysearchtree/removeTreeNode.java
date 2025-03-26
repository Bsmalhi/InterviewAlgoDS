package org.problems.leetcode.binarysearchtree;

public class removeTreeNode {
    public static TreeNode removeNode(TreeNode root, int val){
        if(root == null)
            return null;

        // find the node to delete
        if(val > root.val){
            root.right = removeNode(root.right, val);
        } else if(val < root.val){
            root.left = removeNode(root.left, val);
        } else {
            // 3 conditions
            // left child is null
            if(root.left == null){
                return root.right;
            } else if(root.right == null){ // right child is null
                return root.left;
            } else { // both the child nodes are not null
                // find the min from right subtree to replace with curr node
                TreeNode min = minNode(root.right);
                root.val = min.val;
                root.right = removeNode(root.right, min.val);
            }
        }
        return root;
    }

    public static TreeNode minNode(TreeNode root){
        TreeNode curr = root;
        while(curr != null && curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.insert(root, 7);
        root.insert(root, 4);
        root.insert(root, 3);
        root.insert(root, 8);
        root.insert(root, 6);
        root.inorderPrint(root);
        System.out.println("Remove node from the root with val: " + 7);
        TreeNode removedNode = removeNode(root,7);
        root.inorderPrint(removedNode);
    }
}
