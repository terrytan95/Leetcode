/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (40.02%)
 * Total Accepted:    337K
 * Total Submissions: 842K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 * can use dfs or bfs
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] d = new String[] { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        char[] cur = new char[digits.length()];
        List<String> ans = new ArrayList<>();
        dfs(digits, d, 0, cur, ans);
        return ans;
    }

    private void dfs(String digits, String[] d, int l, char[] cur, List<String> ans) {
        if (l == digits.length()) {
            if (l > 0)
                ans.add(new String(cur));
            return;
        }

        String s = d[Character.getNumericValue(digits.charAt(l))];

        for (int i = 0; i < s.length(); ++i) {
            cur[l] = s.charAt(i);
            dfs(digits, d, l + 1, cur, ans);
        }
    }
}
