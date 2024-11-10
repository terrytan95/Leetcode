/*
 * @lc app=leetcode id=236 lang=javascript
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */

//recursion
//time O(n) need to search all the node
//space O(n)
var lowestCommonAncestor = function(root, p, q) {
	if (!root || !p || !q) {
		return null;
	}
	if (root === p || root === q) {
		return root;
	}

	var left = lowestCommonAncestor(root.left, p, q);
	var right = lowestCommonAncestor(root.right, p, q);

	return left === null ? right : right === null ? left : root;
};
