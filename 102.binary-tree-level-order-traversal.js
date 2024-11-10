var levelOrder = function(root) {
  let result = [];

  if (!root) {
      return result;
  }

  let queue = [root];

  while(queue.length > 0) {
      const currentLength = queue.length;
      const level = [];
      for (i = 0; i < currentLength; i++) {
          let node = queue.shift(0, 1);
          level.push(node.val);
          if (node.left) {
              queue.push(node.left);
          }
          if (node.right) {
              queue.push(node.right);
          }
      }
      result.push(level);
  }
  return result;
};
