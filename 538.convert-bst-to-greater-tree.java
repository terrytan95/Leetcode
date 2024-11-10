/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
 *
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Easy (50.27%)
 * Total Accepted:    73.3K
 * Total Submissions: 145.4K
 * Testcase Example:  '[5,2,13]'
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.
 * 
 * 
 * Example:
 * 
 * Input: The root of a Binary Search Tree like this:
 * ⁠             5
 * ⁠           /   \
 * ⁠          2     13
 * 
 * Output: The root of a Greater Tree like this:
 * ⁠            18
 * ⁠           /   \
 * ⁠         20     13
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution {
    // O(n^2)
    // List<TreeNode> memo = new ArrayList<>();

    // public TreeNode convertBST(TreeNode root) {
    // helper(root);
    // return calculate(root);
    // }

    // private void helper(TreeNode node) {
    // if (node == null)
    // return;
    // this.memo.add(node);
    // helper(node.left);
    // helper(node.right);
    // }

    // private TreeNode calculate(TreeNode root) {
    // if (root == null)
    // return null;

    // int i = root.val;
    // TreeNode newRoot = new TreeNode(i);
    // for (TreeNode node : memo) {
    // if (node.val > root.val) {
    // i += node.val;
    // }
    // }
    // newRoot.val = i;
    // newRoot.left = calculate(root.left);
    // newRoot.right = calculate(root.right);
    // return newRoot;
    // }

    // O(n)
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        // BST中比当前节点值大的节点一定在右子树中.
        inOrder(node.right);

        // 更新当前节点值.
        node.val += sum;
        // 更新sum.
        sum = node.val;

        inOrder(node.left);
    }
}
