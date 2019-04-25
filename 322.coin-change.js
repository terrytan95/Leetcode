/*
 * @lc app=leetcode id=322 lang=javascript
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (29.60%)
 * Total Accepted:    182.4K
 * Total Submissions: 611.1K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * Example 1:
 *
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 *
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 */
/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
	if (coins.length === 0 || amount === 0) return 0;
	var dp = [];
	for (var count = 0; count <= amount; count++) {
		dp[count] = -1;
	}
	dp[0] = 0;

	var set = new Set();
	for (var i = 0; i < coins.length; i++) {
		set.add(coins[i]);
	}

	for (var j = 1; j <= amount; j++) {
		var min = Number.MAX_SAFE_INTEGER;
		if (set.has(j)) dp[j] = 1;
		else {
			for (var k = 0; k < coins.length; k++) {
				if (j > coins[k] && dp[j - coins[k]] !== -1) {
					min = Math.min(min, dp[j - coins[k]]);
					dp[j] = min + 1;
				}
			}
		}
	}
	return dp[amount];
};
