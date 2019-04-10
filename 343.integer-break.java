
/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 *
 * https://leetcode.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (47.46%)
 * Total Accepted:    76.4K
 * Total Submissions: 160.8K
 * Testcase Example:  '2'
 *
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * 
 * 
 */
import java.util.*;

class Solution {
    private static Map<Integer, Integer> small = new HashMap<>();
    private static Map<Integer, Integer> memo = new HashMap<>();

    static {
        small.put(1, 1);
        small.put(2, 1);
        small.put(3, 2);
    }

    public int integerBreak(int n) {
        if (n < 4)
            return small.get(n);
        else
            return helper(n);
    }

    public int helper(int n) {
        if (memo.get(n) != null)
            return memo.get(n);
        if (n == 2)
            return 2;
        else if (n == 3)
            return 3;
        else if (n < 2)
            return 1;
        else {
            int max = Math.max(2 * helper(n - 2), 3 * helper(n - 3));
            memo.put(n, max);
            return max;
        }
    }
}
