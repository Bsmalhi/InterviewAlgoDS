package org.problems.leetcode.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeMap {
    class TreeNode{
        int key;
        int val;
        TreeNode left, right;
        public TreeNode(int key, int val){
            this.val = val;
            this.key = key;
        }

    }

    TreeNode root;
    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        root = helperInsert(root, key, val);
    }
    public TreeNode helperInsert(TreeNode root, int key, int val){
        if(root == null)
            return new TreeNode(key, val);
        if(key < root.key){
            root.left = helperInsert(root.left, key, val);
        } else if(key > root.key){
            root.right = helperInsert(root.right, key, val);
        } else { // if same key found update the val
            root.val = val;
        }
        return root;
    }

    public int get(int key) {
        if(root == null)
            return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.key == key)
                    return node.val;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return -1;
    }

    public int getMin() {
        if(root == null)
            return -1;
        return helperMin(root).val;
    }

    public TreeNode helperMin(TreeNode root){
        TreeNode curr = root;
        while(curr != null && curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    public int getMax() {
        if(root == null)
            return -1;
        TreeNode curr = root;
        while(curr != null && curr.right != null){
            curr = curr.right;
        }
        return curr.val;
    }

    public void remove(int key) {
        root = helperRemove(root, key);
    }

    public TreeNode helperRemove(TreeNode root, int key){
        if(root == null)
            return null;
        if(key < root.key){
            root.left = helperRemove(root.left, key);
        } else if(key > root.key){
            root.right = helperRemove(root.right, key);
        } else {
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }else {
                TreeNode min = helperMin(root.right);
                root.key = min.key;
                root.val = min.val;
                root.right = helperRemove(root.right, min.key);
            }
        }
        return root;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    private void inorder(TreeNode root, List<Integer> result){
        if(root == null)
            return;
        inorder(root.left, result);
        result.add(root.key);
        inorder(root.right, result);
    }
}
