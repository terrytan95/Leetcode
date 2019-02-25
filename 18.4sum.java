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
        if (nums == null || nums.length < 4) return new ArrayList<>();
        
        Arrays.sort(nums);
        return kthSum(nums, 4, 0, target);
    }
    public List<List<Integer>> kthSum(int[] nums, int k, int start, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < k) return results;
        
        if (k == 2) return twoSum(nums, start, target);
        
        for (int pos = start; pos < nums.length; pos++) {
            // If we can't find target with the following numbers, quit
            // - `target < nums[pos] * k`: target is too small
            // - `target > nums[nums.length - 1] * k`: target is too big
            if (target < nums[pos] * k || target > nums[nums.length - 1] * k)
                break;
            
			// We now want to find k-1 sums to target - num[pos]
            List<List<Integer>> kthSumResult = kthSum(nums, k - 1, pos + 1, target - nums[pos]);
            
            // If we found results, add them
            for (List<Integer> kthSumList : kthSumResult) {
                kthSumList.add(nums[pos]);
                results.add(kthSumList);
            }
            
            // Skip identical values
            while (pos < nums.length - 1 && nums[pos] == nums[pos + 1])
                pos++;
        }
                
        return results;
    }
    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int end = nums.length - 1;
        
        while (start < end) {
            if (target < nums[start] * 2 || target > nums[end] * 2)
                break;
            
            int sum = nums[start] + nums[end];
            if (sum == target) {
                List<Integer> tmpResult = new ArrayList();
                tmpResult.add(nums[start]);
                tmpResult.add(nums[end]);
                
                results.add(tmpResult);
                
                // Skip identical values
                while (start < end && nums[start] == tmpResult.get(0)) { start++; }
                while (start < end && nums[end] == tmpResult.get(1)) { end--; }
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        
        return results;
    }
}
