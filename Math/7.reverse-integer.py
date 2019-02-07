#
# @lc app=leetcode id=7 lang=python3
#
# [7] Reverse Integer
#
# https://leetcode.com/problems/reverse-integer/description/
#
# algorithms
# Easy (25.06%)
# Total Accepted:    590.9K
# Total Submissions: 2.4M
# Testcase Example:  '123'
#
# Given a 32-bit signed integer, reverse digits of an integer.
# 
# Example 1:
# 
# 
# Input: 123
# Output: 321
# 
# 
# Example 2:
# 
# 
# Input: -123
# Output: -321
# 
# 
# Example 3:
# 
# 
# Input: 120
# Output: 21
# 
# 
# Note:
# Assume we are dealing with an environment which could only store integers
# within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
# this problem, assume that your function returns 0 when the reversed integer
# overflows.
# 
#
import math
class Solution:
    def reverse(self, x: 'int') -> 'int':
        #when x out of bound or x == 0
        if x < -pow(2, 31) or x > pow(2, 31) - 1:
            return 0
        
        #when x is a one digit number
        if x in range(-9, 10):
            return x

        #other conditions
        intStr = str(x)
        resStr = intStr[::-1]

        #negative
        if resStr[-1] == "-":
            resStr = "-" + resStr[:-1]

        #have 0 in the front
        while(resStr[0] == "0"):
            resStr = resStr[1:]
        result = int(resStr)
        if result < -pow(2, 31) or result > pow(2, 31) - 1:
            return 0
        return result
