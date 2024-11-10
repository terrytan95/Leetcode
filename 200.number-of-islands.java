/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (39.98%)
 * Total Accepted:    319.2K
 * Total Submissions: 784.6K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 * 
 */
import java.util.*;

class Point{
    int row;
    int col;
    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    //BFS
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid == null || grid.length == 0)
            return count;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i ,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int row, int col){
        grid[row][col] = '0';
        int i = grid.length;
        int j = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(row, col);
        queue.offer(point);
        while(!queue.isEmpty()){
            point = queue.poll();
            int r = point.row;
            int c = point.col;
            if(r > 0 && grid[r - 1][c] == '1'){
                queue.offer(new Point(r - 1, c));
                grid[r - 1][c] = '0';
            }
            if(r < i - 1 && grid[r + 1][c] == '1'){
                queue.offer(new Point(r + 1, c));
                grid[r + 1][c] = '0';
            }
            if(c > 0 && grid[r][c - 1] == '1'){
                queue.offer(new Point(r, c - 1));
                grid[r][c - 1] = '0';
            }
            if(c < j - 1 && grid[r][c + 1] == '1'){
                queue.offer(new Point(r, c + 1));
                grid[r][c + 1] = '0';
            }
        }
    }
    // DFS
    // public int numIslands(char[][] grid) {
    //     int count = 0;
    //     if(grid == null || grid.length == 0)
    //         return count;
    //     for(int i = 0; i < grid.length; i++){
    //         for(int j = 0; j < grid[0].length; j++){
    //             if(grid[i][j] == '1'){
    //                 count++;
    //                 dfs(grid, i, j);
    //             }
    //         }
    //     }
    //     return count;
    // }

    // public void dfs(char[][] grid, int row, int col){
    //     if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1'){
    //         grid[row][col] = '0';
    //         dfs(grid, row - 1, col);
    //         dfs(grid, row + 1, col);
    //         dfs(grid, row, col - 1);
    //         dfs(grid, row, col + 1);
    //     }
    // }
}

