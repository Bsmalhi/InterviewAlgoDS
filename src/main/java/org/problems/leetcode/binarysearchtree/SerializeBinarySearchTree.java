package org.problems.leetcode.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class SerializeBinarySearchTree {
    private int index = 0;
    public String serialize(TreeNode root){
        List<String> result = new ArrayList<>();
        preorder(root, result);
        return String.join(",", result);
    }
    private void preorder(TreeNode root, List<String> result){
        if(root == null){
            result.add("null");
            return;
        }
        result.add("" + root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
    public TreeNode deserialize(String data){
        if(data.length() == 0)
            return null;
        String [] tokens = data.split(",");
        return helper(tokens);
    }
    private TreeNode helper(String[] tokens){
        String token = tokens[index++];
        if(token.equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(token));
        root.left = helper(tokens);
        root.right = helper(tokens);
        return root;
    }

    public static void main(String[] args) {
        SerializeBinarySearchTree sb = new SerializeBinarySearchTree();
        TreeNode root = new TreeNode(2);
        root.insert(root, 1);
        root.insert(root, 3);
        String data = sb.serialize(root);
        System.out.println("Serialized Tree " + data);
        TreeNode node = sb.deserialize(data);
        node.inorderPrint(node);
    }
}
