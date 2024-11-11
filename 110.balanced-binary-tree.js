/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function(root) {
  let isBalanced = true;
  const getHeight = node => {
      if (!node) return 0;
      const leftHeight = getHeight(node.left);
      const rightHeight = getHeight(node.right);
      if (Math.abs(leftHeight - rightHeight) > 1) isBalanced = false;
      return Math.max(leftHeight, rightHeight) + 1;
  }
  getHeight(root);
  return isBalanced;
};
