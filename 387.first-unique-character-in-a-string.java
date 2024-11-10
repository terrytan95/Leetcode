/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (48.86%)
 * Total Accepted:    241.7K
 * Total Submissions: 488.9K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */
import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[128];
        for(char t: s.toCharArray())
            count[t]++;
            
        for(int i = 0; i < s.length(); i++)
            if(count[s.charAt(i)] == 1)
                return i;
        return -1;
    }
}

