package org.problems.leetcode.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBST {
    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                res.add(node.val);
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right != null) {
                    queue.offer(root.right);
                }
            }
            result.add(res);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.insert(root, 4);
        root.insert(root, 3);
        root.insert(root, 6);
        root.insert(root, 7);
        root.inorderPrint(root);
        for(List<Integer> l : levelOrderTraversal(root)){
            for(int n: l){
                System.out.println(" " + n);
            }
            System.out.println();
        }
    }
}



