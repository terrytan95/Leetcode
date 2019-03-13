/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * algorithms
 * Medium (45.11%)
 * Total Accepted:    53.3K
 * Total Submissions: 116.9K
 * Testcase Example:  '"bbbab"'
 *
 * 
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 * 
 * 
 * Example 1:
 * Input: 
 * 
 * "bbbab"
 * 
 * Output: 
 * 
 * 4
 * 
 * One possible longest palindromic subsequence is "bbbb".
 * 
 * 
 * Example 2:
 * Input:
 * 
 * "cbbd"
 * 
 * Output:
 * 
 * 2
 * 
 * One possible longest palindromic subsequence is "bb".
 * 
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 0 || s == null){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }

        int len = 0, longest = 0;
        for(int i = 0; i < s.length(); i++){
            len = getLongest(i, i, s);
            if(len > longest){
                longest = len;
            }

            len = getLongest(i, i + 1, s);
            if(len > longest){
                longest = len;
            } 
        }
        return longest;
    }

    public int getLongest(int start, int end, String s){
        int len = 0;
        while(start >= 0 && end < s.length()){
            if(s.charAt(start) != s.charAt(end)){
                break;
            }
            len += start == end ? 1 : 2;
            start--;
            end++;
        }
        return len;
    }
}

