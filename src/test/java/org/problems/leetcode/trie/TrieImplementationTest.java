package org.problems.leetcode.trie;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieImplementationTest {
    static TrieImplementation trie;

    @BeforeAll
    public static void setUp(){
        trie = new TrieImplementation();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");
    }

    @Test
    void isWordPresent() {
        assertTrue(trie.isWordPresent("orange"));
    }

    @Test
    void containsPrefix() {
        assertTrue(trie.containsPrefix("oran"));
    }
}