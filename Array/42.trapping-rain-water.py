#
# @lc app=leetcode id=42 lang=python3
#
# [42] Trapping Rain Water
#
# https://leetcode.com/problems/trapping-rain-water/description/
#
# algorithms
# Hard (41.36%)
# Total Accepted:    246.3K
# Total Submissions: 595.4K
# Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
#
# Given n non-negative integers representing an elevation map where the width
# of each bar is 1, compute how much water it is able to trap after raining.
# 
# 
# The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
# this case, 6 units of rain water (blue section) are being trapped. Thanks
# Marcos for contributing this image!
# 
# Example:
# 
# 
# Input: [0,1,0,2,1,0,1,3,2,1,2,1]
# Output: 6
# 
#
class Solution:
    def trap(self, height: 'List[int]') -> 'int':
        left = 0
        right = len(height) - 1
        maxLeft = 0
        maxRight = 0
        result = 0
        while(left < right):
        	if (height[left] < height[right]):
        		maxLeft = max(height[left], maxLeft)
        		result += maxLeft - height[left]
        		left += 1
        	else:
        		maxRight = max(height[right], maxRight)
        		result += maxRight - height[right]
        		right -= 1

        return result
