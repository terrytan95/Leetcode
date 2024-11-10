/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 *
 * https://leetcode.com/problems/backspace-string-compare/description/
 *
 * algorithms
 * Easy (44.95%)
 * Total Accepted:    43.9K
 * Total Submissions: 97.1K
 * Testcase Example:  '"ab#c"\n"ad#c"'
 *
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * 
 * 
 * Follow up:
 * 
 * 
 * Can you solve it in O(N) time and O(1) space?
 * 
 * 
 * 
 * 
 * 
 * 
 */
import java.lang.*;
class Solution {
    public boolean backspaceCompare(String S, String T) {
        // use two string builders to build new strings
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
		// // loop through S
        // for (int i = 0; i < S.length(); i++) {
        //     char c = S.charAt(i);
		// 	// if c is not #, we append it to sb1
        //     if (c != '#') sb1.append(c);
		// 	// if c is # and there is a char before it in sb1, we delete the previous one
        //     else if (c == '#' && sb1.length() > 0) sb1.deleteCharAt(sb1.length() - 1);
		// 	// if c is # and there is not a char before it, we don't do anything
        // }
        
		// // same logic as above
        // for (int i = 0; i < T.length(); i++) {
        //     char c = T.charAt(i);
        //     if (c != '#') sb2.append(c);
        //     else if (c == '#' && sb2.length() > 0) sb2.deleteCharAt(sb2.length() - 1);
        // }
        int skips = 0;
        for(int i = S.length() - 1; i >= 0; i--){
            char c = S.charAt(i);
            if(c == '#'){
                skips++;
                continue;
            }
            if(c != '#'){
                if(skips > 0){
                    skips--;
                    continue;
                }else{
                    sb1.append(c);
                }
            }
        }
        int skipt = 0;
        for(int i = T.length() - 1; i >= 0; i--){
            char c = T.charAt(i);
            if(c == '#') {
                skipt++;
                continue;
            }
            if(c != '#') {
                if(skipt > 0){
                    skipt--;
                    continue;
                }else{
                    sb2.append(c);
                }
            };
            
        }
		
		// we compare two strings
        return sb1.toString().equals(sb2.toString());
    }
}
