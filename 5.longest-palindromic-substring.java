/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.35%)
 * Total Accepted:    470.1K
 * Total Submissions: 1.8M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("") || s == null) return "";
        String result = "";
        for (int i = 0; i < s.length(); ++i){
            String temp1 = palindrome(s, i, i);
            if (temp1.length() > result.length()){
                result = temp1;
            }
            String temp2 = palindrome(s, i, i+1);
            if (temp2.length() > result.length()){
                result = temp2;
            }
        }
        return result;
    }

    public static String palindrome(String s, int start, int end){
            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                --start;
                ++end;
            }
            return s.substring(start + 1, end);
    }
}
