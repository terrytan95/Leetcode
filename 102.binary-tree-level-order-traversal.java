/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (46.68%)
 * Total Accepted:    348.7K
 * Total Submissions: 734.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List result = new ArrayList();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                int val = node.val;
                level.add(val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    // //iterative dfs
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List result = new ArrayList();

    //     if(root == null){
    //         return result;
    //     }

    //     int maxLevel = 0;

    //     while(true){
    //         ArrayList<Integer> level = new ArrayList<>();
    //         dfs(level, root, 0, maxLevel);
    //         if(level.size() == 0) {
    //             break;
    //         }
    //         result.add(level);
    //         maxLevel++;
    //     }
    //     return result;
    // }

    // public void dfs(List<Integer> level, TreeNode root, int curLevel, int maxLevel){
    //     if(root == null || curLevel > maxLevel){
    //         return;
    //     }

    //     if(curLevel == maxLevel){
    //         level.add(root.val);
    //         return;
    //     }

    //     dfs(level, root.left, curLevel + 1, maxLevel);
    //     dfs(level, root.right, curLevel + 1, maxLevel);
    // }
}

