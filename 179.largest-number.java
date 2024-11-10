
/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (25.44%)
 * Total Accepted:    124.1K
 * Total Submissions: 487.5K
 * Testcase Example:  '[10,2]'
 *
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * Example 1:
 * 
 * 
 * Input: [10,2]
 * Output: "210"
 * 
 * Example 2:
 * 
 * 
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * 
 * 
 * Note: The result may be very large, so you need to return a string instead
 * of an integer.
 * 
 */
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        // change to String array.
        String[] s_nums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_nums[i] = nums[i] + "";
        }

        // comparator to decide which string comes first in concatenation
        Comparator<String> comparator = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                // the first concatenation
                String s1 = o1 + o2;
                // 2nd concatenation
                String s2 = o2 + o1;
                // compare
                return s2.compareTo(s1);
                // reverse order because we need to concatenate from large to small.
            }
        };

        Arrays.sort(s_nums, comparator);
        // now the array is in a descending order...
        // edge case: if you only have 0 in array
        if (s_nums[0].charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String item : s_nums) {
            sb.append(item);
        }

        return sb.toString();
    }
}
