/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (53.50%)
 * Total Accepted:    219.7K
 * Total Submissions: 410.2K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array nums of n integers where n > 1,  return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * 
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does
 * not count as extra space for the purpose of space complexity analysis.)
 * 
 */
class Solution {
    // brute force
    // public int[] productExceptSelf(int[] nums) {
    //     int[] output = new int[nums.length];
    //     for(int i = 0; i < nums.length; i++){
    //         int temp = 1;
    //         for(int j = 0; j < nums.length; j++){
    //             if(j == i) continue;
    //             temp *= nums[j];
    //         }
    //         output[i] = temp;
    //     }
    //     return output;
    // }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0, leftProduct = 1; i < nums.length; i++) { // left product
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        for(int i = nums.length - 1, rightProduct = 1; i >= 0; i--) { // right product
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
}
