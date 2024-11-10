
/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 *
 * https://leetcode.com/problems/course-schedule-ii/description/
 *
 * algorithms Medium (33.39%) Total Accepted: 135.7K Total Submissions: 399.1K
 * Testcase Example: '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] Output: [0,1] Explanation: There are a total of 2 courses
 * to take. To take course 1 you should have finished course 0. So the correct
 * course order is [0,1] .
 * 
 * Example 2:
 * 
 * 
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]] Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you
 * should have finished both ⁠ courses 1 and 2. Both courses 1 and 2 should be
 * taken after you finished course 0. So one correct course order is [0,1,2,3].
 * Another correct ordering is [0,2,1,3] .
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented. You may
 * assume that there are no duplicate edges in the input prerequisites.
 * 
 * 
 */
import java.util.*;
// regular topological sort solution
// class Solution {
// int idx = 0;
// int[] sorted;
// int[] visited;
// List<List<Integer>> g;

// public int[] findOrder(int numCourses, int[][] prerequisites) {
// // 0: unvisited
// // 1: visiting
// // 2: visited
// visited = new int[numCourses];
// sorted = new int[numCourses];
// g = new ArrayList<>();
// for (int i = 0; i < numCourses; i++) {
// g.add(new ArrayList<Integer>());
// }
// for (int[] p: prerequisites) {
// g.get(p[0]).add(p[1]);
// }
// for (int i = 0; i < numCourses; i++) {
// if (visited[i] != 0) continue;
// if (!dfs(i)) return new int[0];
// }
// return sorted;
// }

// boolean dfs(int c) {
// visited[c] = 1;
// for (int nb: g.get(c)) {
// if (visited[nb] == 2) continue;
// if (visited[nb] == 1) return false;
// if (!dfs(nb)) return false;
// }
// visited[c] = 2;
// sorted[idx++] = c;
// return true;
// }
// }

// another better topological sort solution
class Solution {
    public int[] findOrder(int numCourse, int[][] prerequisites) {

        // build result List and List array for all course to save respective
        // prerequisites.
        List<Integer> resList = new ArrayList<Integer>();
        List<Integer>[] map = new ArrayList[numCourse];

        int[] degree = new int[numCourse];// greater degree means higher priority

        // initiate map array
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<Integer>();
        }
        // allocate priorities
        for (int[] pair : prerequisites) {
            map[pair[0]].add(pair[1]);
            degree[pair[1]]++;
        }

        Queue<Integer> startoff = new LinkedList<>();
        for (int i = 0; i < numCourse; i++) {
            if (degree[i] == 0) {
                resList.add(i); // lowest priority courses are added to the end
                startoff.offer(i);
            }
        }

        while (!startoff.isEmpty()) {
            int current = startoff.poll();
            for (int pre : map[current]) {
                if (--degree[pre] == 0) {
                    startoff.offer(pre);
                    resList.add(0, pre);// higher priority courses are added from the beginning
                }
            }
        }

        for (int i = 0; i < numCourse; i++) {
            if (degree[i] != 0)
                return new int[] {};
        }

        int[] result = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = resList.get(i);
        }

        return result;
    }
}
