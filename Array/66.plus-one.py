#
# @lc app=leetcode id=66 lang=python3
#
# [66] Plus One
#
# https://leetcode.com/problems/plus-one/description/
#
# algorithms
# Easy (40.53%)
# Total Accepted:    342.5K
# Total Submissions: 845.2K
# Testcase Example:  '[1,2,3]'
#
# Given a non-empty array of digits representing a non-negative integer, plus
# one to the integer.
#
# The digits are stored such that the most significant digit is at the head of
# the list, and each element in the array contain a single digit.
#
# You may assume the integer does not contain any leading zero, except the
# number 0 itself.
#
# Example 1:
#
#
# Input: [1,2,3]
# Output: [1,2,4]
# Explanation: The array represents the integer 123.
#
#
# Example 2:
#
#
# Input: [4,3,2,1]
# Output: [4,3,2,2]
# Explanation: The array represents the integer 4321.
#
#
# 1. add one if 1st digit is not 9
# 2. carry += 1 if 1st digit is 9
# 3. move forward if carry is bigger than 0
# 4. if number at current digit is not 9, number += 1
# 5. if index == 0 and carry == 1: insert(0, 1) #insert(index, obj)


class Solution:
    def plusOne(self, digits: 'List[int]') -> 'List[int]':
        currentDigit = len(digits) - 1
        if digits[-1] != 9:
            digits[-1] += 1
            return digits
        else:
            while currentDigit >= 0:
                if digits[currentDigit] != 9:
                    digits[currentDigit] += 1
                    return digits
                else:
                    digits[currentDigit] = 0
                    currentDigit -= 1
            digits.insert(0, 1)
            return digits
