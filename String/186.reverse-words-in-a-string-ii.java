/*
 * @lc app=leetcode id=186 lang=java
 *
 * [186] Reverse Words in a String II
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
 *
 * algorithms
 * Medium (35.71%)
 * Total Accepted:    58.7K
 * Total Submissions: 164.4K
 * Testcase Example:  '["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]'
 *
 * Given an input string , reverse the string word by word. 
 * 
 * Example:
 * 
 * 
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 
 * Note: 
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * 
 * 
 * Follow up: Could you do it in-place without allocating extra space?
 * 
 */
class Solution {
    public void reverseWords(char[] str) {
        int length = str.length;
        if(length == 0 || length == 1){
            return;
        }
        reverseWord(str, 0, length - 1);
        int start = 0, end = 0;
        while(start < length){
            end = start;
            while((end + 1 < length) && (str[end + 1] != ' ')){
                ++end;
            }
            reverseWord(str, start, end);
            start = end + 2;
        }
    }

    static void reverseWord(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            ++start;
            --end;
        }
    }
}
