/*
 * @lc app=leetcode id=286 lang=java
 *
 * [286] Walls and Gates
 *
 * https://leetcode.com/problems/walls-and-gates/description/
 *
 * algorithms
 * Medium (48.18%)
 * Total Accepted:    67.5K
 * Total Submissions: 139.8K
 * Testcase Example:  '[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]'
 *
 * You are given a m x n 2D grid initialized with these three possible
 * values.
 * 
 * 
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
 * represent INF as you may assume that the distance to a gate is less than
 * 2147483647.
 * 
 * 
 * Fill each empty room with the distance to its nearest gate. If it is
 * impossible to reach a gate, it should be filled with INF.
 * 
 * Example: 
 * 
 * Given the 2D grid:
 * 
 * 
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * ⁠ 0  -1 INF INF
 * 
 * 
 * After running your function, the 2D grid should be:
 * 
 * 
 * ⁠ 3  -1   0   1
 * ⁠ 2   2   1  -1
 * ⁠ 1  -1   2  -1
 * ⁠ 0  -1   3   4
 * 
 * 
 */
import java.util.*;
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int col;
        int row;
        if(!(rooms.length == 0 || romms[0].length == 0 || rooms == null)){
            col = rooms[0].length;
            row = rooms.length;
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    if(rooms[i][j] == -1 || rooms[i][j] == 0) continue;
                    if(rooms[i][j] == 2147483647){
                        dfs(rooms, i, j, 0);
                    }
                }
            }
        }
    }

    public void bfs(int[][] grid, int i, int j, int depth){
        if(i < 0 || i >= grid.length || j < 0 || j > grid[0].length) return;
        depth += 1;
        if(grid[i][j] == 0) 

    }
}
