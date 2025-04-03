package org.problems.leetcode.trie;

public class TrieImplementation {
    TrieNode root;
    public TrieImplementation(){
        this.root = new TrieNode();
    }
    public void insert(String word){
        word = word.toLowerCase();
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    public boolean isWordPresent(String word){
        word = word.toLowerCase();
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        if(!curr.isWord)
            return false;
        return true;
    }
    public boolean containsPrefix(String prefix){
        TrieNode curr = root;
        for(char c : prefix.toCharArray()){
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        TrieImplementation trie = new TrieImplementation();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");
        System.out.println("Is banana present " + trie.isWordPresent("banana"));
    }
}
