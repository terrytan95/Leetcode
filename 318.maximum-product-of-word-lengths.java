/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 *
 * algorithms
 * Medium (55.94%)
 * Likes:    1503
 * Dislikes: 92
 * Total Accepted:    135.1K
 * Total Submissions: 241.5K
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * Given a string array words, return the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. If no such
 * two words exist, return 0.
 *
 *
 * Example 1:
 *
 *
 * Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 *
 *
 * Example 2:
 *
 *
 * Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 *
 *
 * Example 3:
 *
 *
 * Input: words = ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] consists only of lowercase English letters.
 *
 *
 */

// @lc code=start
class Solution {
    public int bitNumber(char ch) {
        return (int)ch - (int)'a';
    }
    public int maxProduct(String[] words) {
        HashMap<Integer, Integer> hashmap = new HashMap();

        int bitmask = 0;
        int bitNum = 0;
        for (String word : words) {
            bitmask = 0;
            for (char ch : word.toCharArray()) {
                bitmask |= 1 << bitNumber(ch);
            }
            hashmap.put(bitmask, Math.max(hashmap.getOrDefault(bitmask, 0), word.length()));
        }
        int maxProd = 0;
        for (Integer x : hashmap.keySet()) {
            for (int y : hashmap.keySet()) {
                if ((x & y) == 0) {
                    maxProd = Math.max(maxProd, hashmap.get(x) * hashmap.get(y));
                }
            }
        }
        return maxProd;
    }
}
// @lc code=end

