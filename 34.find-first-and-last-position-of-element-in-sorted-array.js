/*
 * @lc app=leetcode id=34 lang=javascript
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
//binary search then spread
//time O(logn)
//space O(1)
var searchRange = function(nums, target) {
	if (nums.length === 0) return [-1, -1];
	let left = 0;
	let right = nums.length - 1;
	while (left <= right) {
		let mid = left + ~~((right - left) / 2);
		if (nums[mid] === target) {
			return findRange(nums, mid);
		} else if (nums[mid] < target) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}
	return [-1, -1];
};

var findRange = function(nums, index) {
	let start = index;
	while (start > 0 && nums[start] === nums[start - 1]) {
		start--;
	}
	let end = index;
	while (end < nums.length - 1 && nums[end] === nums[end + 1]) {
		end++;
	}

	return [start, end];
};
