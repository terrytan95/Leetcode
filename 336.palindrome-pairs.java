import java.util.ArrayList;

/*
 * @lc app=leetcode id=336 lang=java
 *
 * [336] Palindrome Pairs
 *
 * https://leetcode.com/problems/palindrome-pairs/description/
 *
 * algorithms
 * Hard (29.80%)
 * Total Accepted:    63.1K
 * Total Submissions: 207.8K
 * Testcase Example:  '["abcd","dcba","lls","s","sssll"]'
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]] 
 * Explanation: The palindromes are
 * ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]] 
 * Explanation: The palindromes are ["battab","tabbat"]
 * 
 * 
 * 
 */
import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words.length == 0 || words == null)
            return res;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                ArrayList<Integer> pair1 = new ArrayList<>(2);

                if (this.isPalindrome(words[i] + words[j])) {
                    pair1.add(i);
                    pair1.add(j);
                    res.add(pair1);
                }
                ArrayList<Integer> pair2 = new ArrayList<>(2);

                if (this.isPalindrome(words[j] + words[i])) {
                    pair2.add(j);
                    pair2.add(i);
                    res.add(pair2);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i <= c.length / 2 - 1; i++) {
            if (c[i] != c[c.length - 1 - i])
                return false;
        }
        return true;
    }
}

// class Solution {

//     class TrieNode {
//         TrieNode[] children;
//         int index;
//         List<Integer> list;

//         public TrieNode() {
//             this.children = new TrieNode[26];
//             this.index = -1;
//             list = new ArrayList<>();
//         }
//     }

//     public List<List<Integer>> palindromePairs(String[] words) {
//         List<List<Integer>> res = new ArrayList<>();
//         TrieNode root = new TrieNode();
//         if (words == null || words.length == 0) {
//             return res;
//         }

//         for (int i = 0; i < words.length; i++) {
//             insert(root, words[i], i);
//         }

//         for (int i = 0; i < words.length; i++) {
//             search(root, words[i], i, res);
//         }
//         return res;

//     }

//     private void insert(TrieNode root, String word, int index) {
//         for (int i = word.length() - 1; i >= 0; i--) {
//             int j = word.charAt(i) - 'a';
//             if (root.children[j] == null) {
//                 root.children[j] = new TrieNode();
//             }
//             if (isPalindrome(word, 0, i)) {
//                 root.list.add(index);
//             }
//             root = root.children[j];

//         }
//         root.index = index;
//         root.list.add(index);
//     }

//     private void search(TrieNode root, String word, int index, List<List<Integer>> res) {
//         for (int i = 0; i < word.length(); i++) {
//             if (root.index >= 0 && root.index != index && isPalindrome(word, i, word.length() - 1)) {
//                 res.add(Arrays.asList(index, root.index));
//             }
//             root = root.children[word.charAt(i) - 'a'];
//             if (root == null) {
//                 return;
//             }
//         }

//         for (int j : root.list) {
//             if (index != j) {
//                 res.add(Arrays.asList(index, j));
//             }
//         }
//     }

//     private boolean isPalindrome(String word, int i, int j) {
//         while (i < j) {
//             if (word.charAt(i) != word.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }
