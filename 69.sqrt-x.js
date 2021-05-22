/*
 * @lc app=leetcode id=69 lang=javascript
 *
 * [69] Sqrt(x)
 */

// @lc code=start
/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    let left = 0;
    let right = x;
    let res = -1;
    while (left <= right) { // left should be equal to right
      let mid = Math.round((left + right) / 2);
      let prod = mid * mid;
      if (prod <= x) {
        res = mid;
        left = mid + 1;
      } else if (prod > x) {
        right = mid - 1;
      } else {
        return mid;
      }
    }
    return res;
};
// @lc code=end

