/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.73%)
 * Total Accepted:    390.4K
 * Total Submissions: 1.2M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        return helper(nums, 0, nums.length - 1, target);
    }

    private int helper(int[] nums, int first, int last, int target) {
        if (first > last)
            return -1;

        int mid = (first + last) / 2;
        if (nums[mid] == target)
            return mid;

        if (nums[first] <= nums[mid]) {// Left half is sorted
            if (nums[first] <= target && target <= nums[mid]) // target is in this sorted (left) half
                return helper(nums, first, mid - 1, target);
            else // target must be in the right half
                return helper(nums, mid + 1, last, target);
        }

        if (nums[mid] <= nums[last]) {// Right half is sorted
            if (nums[mid] <= target && target <= nums[last]) // target is in this sorted (right) half
                return helper(nums, mid + 1, last, target);
            else // target must be in left half
                return helper(nums, first, mid - 1, target);
        }

        return -1;
    }
}
