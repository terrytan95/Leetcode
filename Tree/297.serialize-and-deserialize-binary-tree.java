import java.util.ArrayList;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (39.00%)
 * Total Accepted:    155.9K
 * Total Submissions: 399.7K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Example: 
 * 
 * 
 * You may serialize the following tree:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 * 
 * as "[1,2,3,null,null,4,5]"
 * 
 * 
 * Clarification: The above format is the same as how LeetCode serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {
    int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null,";
        String data = "";
        if(i == 0){
            data += root.val + ",";
            ++i;
        }
        String left = serialize(root.left);
        String right = serialize(root.right);

        data += left + right;
        return data;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null,")) return null;
        data = data.substring(0, data.length() - 1);
        System.out.println(data);

        String[] strList = data.split("\\,");
        System.out.println(strList[6]);
        ArrayList<Integer> dataList = new ArrayList<Integer>();
        for (String item : strList) {
            if (item.equals("null")) {
                dataList.add(null);
            } else {
                dataList.add(Integer.parseInt(item));
            }
        }
        TreeNode root = new TreeNode(dataList.get(0));
        dataList.remove(0);
        TreeNode left = root.left;
        TreeNode right = root.right;
        while(!dataList.isEmpty()){
            if(dataList.get(0) == null){
                left = null;
            }else{
                left.val = dataList.get(0);
                dataList.remove(0);
                left = left.left;
            }

            if(dataList.get(0) == null){
                right = null;
            }else{
                right.val = dataList.get(0);
                dataList.remove(0);
                right = right.right;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
