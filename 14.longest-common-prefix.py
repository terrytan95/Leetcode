#
# @lc app=leetcode id=14 lang=python3
#
# [14] Longest Common Prefix
#
# https://leetcode.com/problems/longest-common-prefix/description/
#
# algorithms
# Easy (32.86%)
# Total Accepted:    397K
# Total Submissions: 1.2M
# Testcase Example:  '["flower","flow","flight"]'
#
# Write a function to find the longest common prefix string amongst an array of
# strings.
# 
# If there is no common prefix, return an empty string "".
# 
# Example 1:
# 
# 
# Input: ["flower","flow","flight"]
# Output: "fl"
# 
# 
# Example 2:
# 
# 
# Input: ["dog","racecar","car"]
# Output: ""
# Explanation: There is no common prefix among the input strings.
# 
# 
# Note:
# 
# All given inputs are in lowercase letters a-z.
# 
#
class Solution:
    def longestCommonPrefix(self, strs: 'List[str]') -> 'str':
        if strs == []:
            return ""
        minLen = len(strs[0])
        for s in strs:
            minLen = min(minLen, len(s))
        idx = 0
        for col in range(minLen):
            for row in range(len(strs)):
                if strs[0][col] != strs[row][col]:
                    return strs[0][0:idx]
            idx += 1
        return strs[0][0:idx]
