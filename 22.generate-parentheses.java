
/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (53.80%)
 * Total Accepted:    316.9K
 * Total Submissions: 587.8K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
import java.util.*;

class Solution {
    private List<String> res;
    private int N;

    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        this.N = n;
        backtrack(0, "");
        return res;
    }

    private void backtrack(int bal, String prefix) {
        if (bal == 0 && prefix.length() == 2 * N) {
            res.add(prefix);
            return;
        }

        if (bal < 0 || prefix.length() > 2 * N) {
            return;
        }

        backtrack(bal + 1, prefix + '(');
        backtrack(bal - 1, prefix + ')');

    }
}
