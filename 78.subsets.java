/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (50.53%)
 * Total Accepted:    335.9K
 * Total Submissions: 655.3K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        Arrays.sort(nums);

        for (int num : nums) {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                List<Integer> tmp = new ArrayList<>(ans.get(i));
                tmp.add(num);
                ans.add(tmp);
            }
        }

        return ans;
    }
}

// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         if(nums==null) return res;
//         List<Integer> temp = new ArrayList<>();
//         dfs(nums, temp, res, 0);
//         return res;
//     }
    
//     private void dfs(int[] nums, List<Integer> temp, List<List<Integer>> res, int index){
//         if(index==nums.length){
//             res.add(new ArrayList<>(temp));
//             return;
//         }
//         dfs(nums, temp, res, index+1);
//         temp.add(nums[index]);
//         dfs(nums, temp, res, index+1);
//         temp.remove(temp.size()-1);
        
//     }
// }
