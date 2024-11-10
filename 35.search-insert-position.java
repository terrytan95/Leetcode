import java.util.Arrays;

/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (40.37%)
 * Total Accepted:    360.9K
 * Total Submissions: 892.5K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [1,3,5,6], 0
 * Output: 0
 * 
 * 
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length==0)return 0;
        return searchBinary(nums, target, 0, nums.length-1);
    }

    public int searchBinary(int[]nums, int target, int i, int j){
        if (i==j){
            if (nums[i]==target)return i;
            else if (nums[i]<target)return i+1;
            else return i;
        }
        else {
            int middle = i + (j-i)/2;
            if (nums[middle]==target)return middle;
            else if (nums[middle]>target)return searchBinary(nums, target, i, middle);
            else return searchBinary(nums, target, middle+1, j);
        }
    }
}
