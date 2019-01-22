class Solution(object):
    def longestPalindromeSubseq(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        dp = [0] * n
        j = 0
        while j < n:
            dp[j] = 1
            prev = 0
            i = j - 1
            while i >= 0:
                temp = dp[i]
                if s[i] == s[j]:
                    dp[i] = 2 + prev
                else:
                    dp[i] = max(dp[i+1], dp[i])
                prev = temp
                i -= 1
            j += 1
        return dp[0]
        

sol = Solution()
print(sol.longestPalindromeSubseq(""))