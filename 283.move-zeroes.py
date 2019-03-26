#
# @lc app=leetcode id=283 lang=python3
#
# [283] Move Zeroes
#
# https://leetcode.com/problems/move-zeroes/description/
#
# algorithms
# Easy (53.38%)
# Total Accepted:    409.8K
# Total Submissions: 767.8K
# Testcase Example:  '[0,1,0,3,12]'
#
# Given an array nums, write a function to move all 0's to the end of it while
# maintaining the relative order of the non-zero elements.
# 
# Example:
# 
# 
# Input: [0,1,0,3,12]
# Output: [1,3,12,0,0]
# 
# Note:
# 
# 
# You must do this in-place without making a copy of the array.
# Minimize the total number of operations.
# 
#
class Solution:
    def moveZeroes(self, nums: 'List[int]') -> 'None':
        """ 
        Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        i = 0
        j = 0
        while i < length:
            if nums[j] == 0:
                nums.pop(j)
                nums.append(0)
            else: j += 1
            i += 1
        
