package org.problems.leetcode.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == 0)
                    result.add(node.val);
                if(node.right != null){ // fifo queue so right side goes out first
                    queue.offer(node.right);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.insert(root, 3);
        root.insert(root, 4);
        root.insert(root, 6);
        root.insert(root, 8);
//        root.inorderPrint(root);
        System.out.print("Right side view : ");
        for(int i : rightSideView(root))
            System.out.print(" "+ i);
        System.out.println();
    }
}
