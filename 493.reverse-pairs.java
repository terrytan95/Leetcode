/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 *
 * https://leetcode.com/problems/reverse-pairs/description/
 *
 * algorithms
 * Hard (28.74%)
 * Likes:    2052
 * Dislikes: 164
 * Total Accepted:    67.6K
 * Total Submissions: 234.8K
 * Testcase Example:  '[1,3,2,3,1]'
 *
 * Given an integer array nums, return the number of reverse pairs in the
 * array.
 *
 * A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] >
 * 2 * nums[j].
 *
 *
 * Example 1:
 * Input: nums = [1,3,2,3,1]
 * Output: 2
 * Example 2:
 * Input: nums = [2,4,3,5,1]
 * Output: 3
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 5 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 *
 */

// @lc code=start
class Solution {
  public int reversePairs(int[] nums) {
      if (nums.length == 0) return 0;
      int[] numsSorted = new int[nums.length];
      return mergeSort(nums, numsSorted, 0, nums.length - 1);
  }

  private int mergeSort(int[] nums, int[] numsSorted, int left, int right) {
      if (left >= right) return 0;
      int mid = left + (right - left) / 2;
      int res = mergeSort(nums, numsSorted, left, mid) +
                mergeSort(nums, numsSorted, mid + 1, right) +
                findReversedPairs(nums, left, right);

      int i = left, j = mid + 1, k = left;

      while (i <= mid && j <= right) {
          if (nums[i] <= nums[j]) {
              numsSorted[k++] = nums[i++];
          } else {
              numsSorted[k++] = nums[j++];
          }
      }

      while (i <= mid) {
          numsSorted[k++] = nums[i++];
      }
      while (j <= right) {
          numsSorted[k++] = nums[j++];
      }
      for (int index = left; index <= right; index++) {
          nums[index] = numsSorted[index];
      }
      return res;
  }

  private int findReversedPairs(int[] nums, int left, int right) {
      int res = 0, mid = left + (right - left) / 2;
      int i = left, j = mid + 1;
      for (;i <= mid; i++){
          while (j <= right && (long)nums[i] > 2*(long)nums[j]) {
              res += mid - i + 1;
              j++;
          }
      }
      return res;
  }
}
// @lc code=end

