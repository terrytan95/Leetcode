#
# @lc app=leetcode id=16 lang=python3
#
# [16] 3Sum Closest
#
# https://leetcode.com/problems/3sum-closest/description/
#
# algorithms
# Medium (33.83%)
# Total Accepted:    233.5K
# Total Submissions: 689.8K
# Testcase Example:  '[-1,2,1,-4]\n1'
#
# Given an array nums of n integers and an integer target, find three integers
# in nums such that the sum is closest to target. Return the sum of the three
# integers. You may assume that each input would have exactly one solution.
# 
# Example:
# 
# 
# Given array nums = [-1, 2, 1, -4], and target = 1.
# 
# The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
# 
# 
#
class Solution:
    def threeSumClosest(self, nums: 'List[int]', target: 'int') -> 'int':
        if nums == [] or nums == None:
            return target
        nums.sort()
        delta = nums[0] + nums[1] + nums[2] - target
        for i in range(len(nums) - 2):
            start = i + 1
            end = len(nums) - 1
            while start < end:
                newDelta = nums[i] + nums[start] + nums[end] - target
                if newDelta == 0:
                    return target
                if abs(delta) > abs(newDelta):
                    delta = newDelta
                if newDelta < 0:
                    start += 1
                else:
                    end -= 1
        return target + delta
  