/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (37.35%)
 * Total Accepted:    169.2K
 * Total Submissions: 451.5K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * 
 * 
 */
class Trie {

    /** Initialize your data structure here. */
    private class Node {
        Node[] children = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();

    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, Node node) {
        int idx = word.charAt(0) - 'a';
        if (node.children[idx] == null) {
            node.children[idx] = new Node();
        }
        if (word.length() == 1)
            node.children[idx].isLeaf = true;
        else
            insert(word.substring(1), node.children[idx]);

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node) {
        if (node == null)
            return false;
        int idx = word.charAt(0) - 'a';
        if (node.children[idx] == null)
            return false;
        if (word.length() == 1)
            return node.children[idx].isLeaf;
        return search(word.substring(1), node.children[idx]);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    private boolean startsWith(String prefix, Node node) {
        if (node == null)
            return false;
        int idx = prefix.charAt(0) - 'a';
        if (node.children[idx] == null)
            return false;
        else {
            if (prefix.length() == 1)
                return true;
            else
                return startsWith(prefix.substring(1), node.children[idx]);
        }
    }
}
/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
