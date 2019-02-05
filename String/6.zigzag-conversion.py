#
# @lc app=leetcode id=6 lang=python3
#
# [6] ZigZag Conversion
#
# https://leetcode.com/problems/zigzag-conversion/description/
#
# algorithms
# Medium (30.31%)
# Total Accepted:    279K
# Total Submissions: 920.7K
# Testcase Example:  '"PAYPALISHIRING"\n3'
#
# The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
# of rows like this: (you may want to display this pattern in a fixed font for
# better legibility)
#
#
# P   A   H   N
# A P L S I I G
# Y   I   R
#
#
# And then read line by line: "PAHNAPLSIIGYIR"
#
# Write the code that will take a string and make this conversion given a
# number of rows:
#
#
# string convert(string s, int numRows);
#
# Example 1:
#
#
# Input: s = "PAYPALISHIRING", numRows = 3
# Output: "PAHNAPLSIIGYIR"
#
#
# Example 2:
#
#
# Input: s = "PAYPALISHIRING", numRows = 4
# Output: "PINALSIGYAHRPI"
# Explanation:
#
# P     I    N
# A   L S  I G
# Y A   H R
# P     I
#
#


class Solution:
    def convert(self, s: 'str', numRows: 'int') -> 'str':
        if numRows == 1 or s == "":
            return s
        
        result = ""
        interval = numRows * 2 - 2
        index = 0

        while index < len(s):
            result += s[index]
            index += interval

        for i in range(1, numRows - 1):
            index = i
            j = interval - 2 * i
            k = interval - j
            while index < len(s):
                result += s[index]
                index += j
                if index < len(s):
                    result += s[index]
                    index += k

        index = numRows - 1
        while index < len(s):
            result += s[index]
            index += interval

        return result
