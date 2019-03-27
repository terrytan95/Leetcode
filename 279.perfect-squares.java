/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (40.41%)
 * Total Accepted:    168.9K
 * Total Submissions: 409.9K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

import java.util.*;
class Solution {
    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; i++){
            nums[i * i] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; i + j * j <= n; j++){
                nums[i + j * j] = Math.min(nums[i] + 1, nums[i + j * j]);
            }
        }
        return nums[n];
    }
}

