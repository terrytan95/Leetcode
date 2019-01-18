class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = 1
        current = 1
        if s == None or s == "": return 0
        substr = s[0]
        while current < len(s):
            now = s[current]
            if now not in substr:
                substr = substr + s[current]
                current = current + 1
                if result < len(substr):
                    result = len(substr)
            else:
                substr = substr[(substr.find(now) + 1):]
        return result
sol = Solution()
print(sol.lengthOfLongestSubstring("asdweasdf"))