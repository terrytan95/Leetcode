
/*
 * @lc app=leetcode id=865 lang=java
 *
 * [865] Smallest Subtree with all the Deepest Nodes
 *
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
 *
 * algorithms
 * Medium (54.74%)
 * Total Accepted:    15.8K
 * Total Submissions: 28.8K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]'
 *
 * Given a binary tree rooted at root, the depth of each node is the shortest
 * distance to the root.
 * 
 * A node is deepest if it has the largest depth possible among any node in the
 * entire tree.
 * 
 * The subtree of a node is that node, plus the set of all descendants of that
 * node.
 * 
 * Return the node with the largest depth such that it contains all the deepest
 * nodes in its subtree.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [3,5,1,6,2,0,8,null,null,7,4]
 * Output: [2,7,4]
 * Explanation:
 * 
 * 
 * 
 * We return the node with value 2, colored in yellow in the diagram.
 * The nodes colored in blue are the deepest nodes of the tree.
 * The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of
 * the given tree.
 * The output "[2, 7, 4]" is a serialization of the subtree rooted at the node
 * with value 2.
 * Both the input and output have TreeNode type.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of nodes in the tree will be between 1 and 500.
 * The values of each node are unique.
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// class Solution {

// private int maxLevel = Integer.MIN_VALUE;
// private TreeNode maxLevelNode = null;
// private TreeNode upperNode = null;

// public TreeNode subtreeWithAllDeepest(TreeNode root) {
// if (root == null)
// return null;
// if (root.left == null && root.right == null)
// return root;
// helper(null, root, 0);
// return upperNode;
// }

// private int helper(TreeNode upperRoot, TreeNode root, int currentLevel) {
// if (root == null)
// return currentLevel - 1;
// int level = Math.max(helper(root, root.left, currentLevel + 1), helper(root,
// root.right, currentLevel + 1));
// if (level > maxLevel) {
// upperNode = upperRoot;
// maxLevelNode = root;
// maxLevel = level;
// }
// return level;
// }
// }

class Solution {
    TreeNode result;
    int maxdepth = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;
        helper(root, 0);
        return result;
    }

    public int helper(TreeNode root, int curdepth) {
        if (root == null) {
            maxdepth = Math.max(maxdepth, curdepth);
            return curdepth;
        }
        // maxdepth = Math.max(maxdepth, curdepth);
        int leftdepth = helper(root.left, curdepth + 1);
        int rightdepth = helper(root.right, curdepth + 1);
        if (leftdepth == maxdepth && rightdepth == maxdepth)
            result = root;
        return Math.max(leftdepth, rightdepth);
    }
}