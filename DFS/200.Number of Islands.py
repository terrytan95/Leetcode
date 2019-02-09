class Solution:
    count = 0
    parent = []
    rank = []

    def UnionFind(self, grid):
        count = 0
        m = len(grid)
        n = len(grid[0])
        parent = [] # length m * n
        rank = [] # length m * n

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    parent[i * n + j] = i * n + j
                    count += 1
                rank[i * n + j] = 0

    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        return 1


test = [['1', '1', '1', '1', '0'], 
        ['1', '1', '0', '1', '0'],
        ['1', '1', '0', '0', '0'],
        ['1', '1', '0', '0', '0'],
        ['0', '0', '0', '0', '0']]

x = Solution()
print(x.numIslands(test))

    
