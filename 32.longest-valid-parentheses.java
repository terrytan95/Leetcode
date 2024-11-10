
/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (25.12%)
 * Total Accepted:    182.1K
 * Total Submissions: 722.1K
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * 
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * 
 */
import java.util.*;

class Solution {
    // Stack
    public int longestValidParentheses(String s) {
        if (s.length() == 0)
            return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (!stack.isEmpty()) {
                    res = Math.max(res, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return res;
    }

    // DP
    // public int longestValidParentheses(String s) {
    // int result = 0;
    // s = ')' + s;
    // int[] dp = new int[s.length()];
    // for (int i = 1; i < s.length(); i++) {
    // if (s.charAt(i) == ')') {
    // if (s.charAt(i - 1 - dp[i - 1]) == '(')
    // dp[i] = dp[i - 1] + 2;
    // dp[i] += dp[i - dp[i]];
    // }
    // result = Math.max(result, dp[i]);
    // }
    // return result;
    // }
}
