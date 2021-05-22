/*
 * @lc app=leetcode id=136 lang=javascript
 *
 * [136] Single Number
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let a = 0;
    nums.forEach(item => {
      a ^= item;
    });
    return a;
};
// @lc code=end

