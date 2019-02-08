#
# @lc app=leetcode id=12 lang=python3
#
# [12] Integer to Roman
#
# https://leetcode.com/problems/integer-to-roman/description/
#
# algorithms
# Medium (49.46%)
# Total Accepted:    198.3K
# Total Submissions: 400.8K
# Testcase Example:  '3'
#
# Roman numerals are represented by seven different symbols: I, V, X, L, C, D
# and M.
# 
# 
# Symbol       Value
# I             1
# V             5
# X             10
# L             50
# C             100
# D             500
# M             1000
# 
# For example, two is written as II in Roman numeral, just two one's added
# together. Twelve is written as, XII, which is simply X + II. The number
# twenty seven is written as XXVII, which is XX + V + II.
# 
# Roman numerals are usually written largest to smallest from left to right.
# However, the numeral for four is not IIII. Instead, the number four is
# written as IV. Because the one is before the five we subtract it making four.
# The same principle applies to the number nine, which is written as IX. There
# are six instances where subtraction is used:
# 
# 
# I can be placed before V (5) and X (10) to make 4 and 9. 
# X can be placed before L (50) and C (100) to make 40 and 90. 
# C can be placed before D (500) and M (1000) to make 400 and 900.
# 
# 
# Given an integer, convert it to a roman numeral. Input is guaranteed to be
# within the range from 1 to 3999.
# 
# Example 1:
# 
# 
# Input: 3
# Output: "III"
# 
# Example 2:
# 
# 
# Input: 4
# Output: "IV"
# 
# Example 3:
# 
# 
# Input: 9
# Output: "IX"
# 
# Example 4:
# 
# 
# Input: 58
# Output: "LVIII"
# Explanation: L = 50, V = 5, III = 3.
# 
# 
# Example 5:
# 
# 
# Input: 1994
# Output: "MCMXCIV"
# Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
# 
#
class Solution:
    def intToRoman(self, num: 'int') -> 'str':
        result = ""
        numM = num//1000
        if numM > 0:
            num -= 1000*numM
            result += numM*"M"
            print(num)

        H = num//100
        if H == 4:
            result += "CD"
            num -= 400
            print(num)
        elif H == 9:
            result += "CM"
            num -= 900
            print(num)
        else:
            if H < 4:
                result += H*"C"
                num -= H*100
                print(num)
            else:
                result += "D" + (H - 5)*"C"
                num -= H*100
                print(num)

        T = num//10
        if T == 4:
            result += "XL"
            num -= 40
            print(num)
        elif T == 9:
            result += "XC"
            num -= 90
            print(num)
        else:
            if T < 4:
                result += T*"X"
                num -= T*10
                print(num)
            else:
                result += "L" + (T - 5)*"X"
                num -= T*10
                print(num)

        print(num)
        if num == 4:
            result += "IV"
        elif num == 9:
            result += "IX"
        else:
            if num < 4:
                result += num*"I"
            else:
                result += "V" + (num - 5)*"I"

        return result
