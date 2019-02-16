import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (26.09%)
 * Total Accepted:    745.5K
 * Total Submissions: 2.8M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        if (s.length() == 1)
            return 1;
        int length = 1;
        AbstractList<Character> chars = new LinkedList<Character>();

        chars.add(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            if (!chars.contains(s.charAt(i))) {
                chars.add(s.charAt(i));
                if (chars.size() > length)
                    length = chars.size();
            } else {
                int index = chars.indexOf(s.charAt(i));
                chars.subList(0, index + 1).clear();;
                chars.add(s.charAt(i));
                Integer.parseInt(s)
            }
        }
        return length;
    }
}
