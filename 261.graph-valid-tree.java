
/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 *
 * https://leetcode.com/problems/graph-valid-tree/description/
 *
 * algorithms
 * Medium (39.58%)
 * Total Accepted:    85.1K
 * Total Submissions: 214.8K
 * Testcase Example:  '5\n[[0,1],[0,2],[0,3],[1,4]]'
 *
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to check whether these edges make
 * up a valid tree.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * 
 * Note: you can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0,1] is the same as [1,0] and thus will not appear
 * together in edges.
 * 
 */
import java.util.*;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || edges.length != n - 1)
            return false;

        Map<Integer, Set<Integer>> adj = initializeMap(n, edges);

        HashSet<Integer> hash = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        hash.add(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int item : adj.get(cur)) {
                if (hash.contains(item))
                    continue;
                hash.add(item);
                queue.offer(item);

            }
        }

        return (hash.size() == n);

    }

    private Map<Integer, Set<Integer>> initializeMap(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        return map;

    }
}
