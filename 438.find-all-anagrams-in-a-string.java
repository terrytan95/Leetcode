
/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Easy (36.78%)
 * Total Accepted:    115K
 * Total Submissions: 312.1K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashSet<Character> chars = new HashSet<>();

        if (s == null || p == null || s.length() < p.length())
            return res;

        int length = p.length();
        int[] backup = new int[26];
        char[] sc = s.toCharArray();
        for (char c : p.toCharArray()) {
            backup[c - 'a']++;
            chars.add(c);
        }
        int[] test = backup.clone();
        for (int i = 0; i < sc.length; i++) {
            if (chars.contains(sc[i])) {
                for (int j = i; j < length + i; j++) {
                    if (j >= sc.length) {
                        break;
                    }
                    test[sc[j] - 'a']--;
                }
                if (testArray(test)) {
                    res.add(i);
                }

                test = backup.clone();

            }
        }
        return res;
    }

    private boolean testArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }
}
