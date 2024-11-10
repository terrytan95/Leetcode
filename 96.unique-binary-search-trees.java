
/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (45.50%)
 * Total Accepted:    191.3K
 * Total Submissions: 419.7K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */
import java.util.*;

class Solution {
    private static Map<Integer, Integer> memo = new HashMap<>();
    static {
        memo.put(0, 1);
        memo.put(1, 1);
        memo.put(2, 2);
        memo.put(3, 5);
    }

    public int numTrees(int n) {
        Integer pre = memo.get(n);
        if (pre != null)
            return pre;
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += numTrees(i) * numTrees(n - 1 - i);
        }
        memo.put(n, num);
        return num;
    }
}
