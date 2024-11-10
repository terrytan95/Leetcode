/**
 * @param {number[][]} mat
 * @return {number[][]}
 */
var updateMatrix = function(mat) {
  let m = mat.length, n = mat[0].length;
  let res = Array.from({length: m}, () => Array(n).fill(-1));
  let q = [];
  for (let i = 0; i < m; i++) {
      for (let j = 0; j < n; j++) {
          if (mat[i][j] == 0) {
              q.push([i, j]);
              res[i][j] = 0;
          }
      }
  }
  let dirs = [[0, 1],[0, -1], [1, 0], [-1, 0]];
  while (q.length > 0) {
      let [x, y] = q.shift();
      for (let i = 0; i < 4; i++) {
          let nextX = x + dirs[i][0];
          let nextY = y + dirs[i][1];
          if (nextX >= 0 &&
              nextX < m &&
              nextY >= 0 &&
              nextY < n &&
              res[nextX][nextY] == -1  
          ) {
              q.push([nextX, nextY]);
              res[nextX][nextY] = res[x][y] + 1;
          }
      }
  }
  return res;
};
