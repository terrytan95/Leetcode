import java.util.HashSet;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (34.08%)
 * Total Accepted:    299.9K
 * Total Submissions: 876.3K
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * 
 */
import java.util.*;

class Solution {
    private boolean[] visited = null;
    private List<String> wordDict = null;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return false;
        visited = new boolean[s.length() + 1];
        this.wordDict = wordDict;
        return visit(s, 0);
    }

    private boolean visit(String s, int offset) {
        if (offset == s.length())
            return true;
        visited[offset] = true;

        for (String word : wordDict) {
            if (s.startsWith(word, offset) && !visited[offset + word.length()]) {
                // We haven't visited here, try it
                if (visit(s, offset + word.length()))
                    return true;
            }
        }
        return false;
    }
}
