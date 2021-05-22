import java.util.*;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (29.45%)
 * Total Accepted:    206.9K
 * Total Submissions: 702.5K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 *
 *
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4 || nums == null)
            return new ArrayList<>();

        Arrays.sort(nums);

        return ksum(nums, 0, 4, target);
    }

    public List<List<Integer>> ksum(int[] nums, int start, int k, int target) {
        if (k == 2)
            return twoSum(nums, start, target);
        List<List<Integer>> result = new ArrayList<>();
        for (int pos = start; pos < nums.length; pos++) {
            if ((nums[pos] * k > target) || (nums[nums.length - 1] * k < target))
                break;

            List<List<Integer>> ksumList = ksum(nums, pos + 1, k - 1, target - nums[pos]);

            for (List<Integer> klist : ksumList) {
                klist.add(nums[pos]);
                result.add(klist);
            }

            while (pos < nums.length - 1 && nums[pos] == nums[pos + 1]) {
                pos++;
            }

        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] * 2 > target || nums[end] * 2 < target)
                break;
            int sum = nums[start] + nums[end];
            if (sum == target) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(nums[start]);
                tempList.add(nums[end]);

                result.add(tempList);

                while (start < end && nums[start] == tempList.get(0))
                    start++;
                while (start < end && nums[end] == tempList.get(1))
                    end--;

            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
