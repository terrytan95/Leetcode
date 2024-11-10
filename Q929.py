class Solution:
    def numUniqueEmails(self, emails):
        """
        :type emails: List[str]
        :rtype: int
        """
        filtered = set()
        for item in emails:
            after = item.split("@")
            left = after[0]
            right = after[1]
            if left.find("+") > -1:
                left = left.split("+")[0]
            if left.find(".") > -1:
                left = left.replace(".","")
            filtered.add(left+right)
        return len(filtered)

sol = Solution()
test = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
print(sol.numUniqueEmails(test))