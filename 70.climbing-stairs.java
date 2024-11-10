import java.util.HashMap;

/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (43.75%)
 * Total Accepted:    379.1K
 * Total Submissions: 865.2K
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 */
class Solution {
    private static HashMap<Integer, Integer> memo = new HashMap<>();
    static {
        memo.put(1, 1);
        memo.put(2, 2);
    }

    public int climbStairs(int n) {
        if (n <= 0)
            return 0;
        if (memo.containsKey(n))
            return memo.get(n);
        else {
            int i = climbStairs(n - 2) + climbStairs(n - 1);
            memo.put(n, i);
            return i;
        }
    }
}
