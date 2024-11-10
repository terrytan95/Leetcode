/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (28.76%)
 * Total Accepted:    199.7K
 * Total Submissions: 692K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */
class Solution {
    public int maxProduct(int[] nums) {
        int minPre = nums[0];
        int maxPre = nums[0];
        int result = nums[0];
        int tempMin = 0;
        int tempMax = 0;

        for (int i = 1; i < nums.length; i++) {
            tempMin = minPre * nums[i];
            tempMax = maxPre * nums[i];
            minPre = Math.min(Math.min(tempMin, tempMax), nums[i]);
            maxPre = Math.max(Math.max(tempMin, tempMax), nums[i]);

            result = Math.max(result, maxPre);
        }
        return result;
    }
}
