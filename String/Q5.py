class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        def palindrome(s, left, right):
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left + 1:right]
        
        answer = ""

        for i in range(len(s)):
            str1 = palindrome(s, i, i)
            if len(str1) > len(answer): answer = str1
            str2 = palindrome(s, i, i + 1)
            if len(str2) > len(answer): answer = str2
        
        return answer
sol = Solution()
print(sol.longestPalindrome("cbbd"))