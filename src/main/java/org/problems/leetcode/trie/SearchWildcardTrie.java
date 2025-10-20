package org.problems.leetcode.trie;

public class SearchWildcardTrie {

    private TrieNode root;
    public SearchWildcardTrie(){
        root = new TrieNode();
    }

    public void addWord(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    // search word which can have wildcard eg. da. or a..
    public boolean search(String word){
        return search(0, root, word);
    }
    public boolean search(int index, TrieNode curr, String word){
        for(int i = index; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                // now as char is wildcard we will have to go to each child
                // to check if char is present then recursively keep checking with DFS
                for(TrieNode child: curr.children){
                    if(child != null && search(i + 1, child, word)){
                        return true;
                    }
                }
                return false; // none of the children could form a word
            } else {
                if(curr.children[c - 'a'] == null)
                    return false;
                curr = curr.children[c - 'a'];
            }
        }
        return curr.isWord;
    }

    public static void main(String[] args) {
        SearchWildcardTrie swt = new SearchWildcardTrie();
        swt.addWord("day");
        swt.addWord("say");
        System.out.println("Search trie contains day : " + swt.search("say"));
    }
}
