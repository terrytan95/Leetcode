/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (46.04%)
 * Total Accepted:    220.5K
 * Total Submissions: 476.7K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */
class Solution {
    // space: O(i * j)
    // public int minPathSum(int[][] grid) {
    // for (int i = 1; i < grid.length; i++)
    // grid[i][0] += grid[i - 1][0];
    // for (int i = 1; i < grid[0].length; i++)
    // grid[0][i] += grid[0][i - 1];
    // for (int i = 1; i < grid.length; i++) {
    // for (int j = 1; j < grid[0].length; j++) {
    // grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
    // }
    // }
    // return grid[grid.length - 1][grid[0].length - 1];
    // }

    // space: O(i)
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid.length];
        // initialize the first col;
        dp[0] = grid[0][0];
        for (int i = 1; i < grid.length; i++)
            dp[i] += dp[i - 1] + grid[i][0];
        for (int j = 1; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                dp[i] = i == 0 ? dp[i] + grid[i][j] : Math.min(dp[i], dp[i - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1];

    }

}
