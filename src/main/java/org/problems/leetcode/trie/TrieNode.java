package org.problems.leetcode.trie;

public class TrieNode {
    boolean isWord;
    TrieNode [] children;
    public TrieNode(){
        this.children = new TrieNode[26];
    }
}
