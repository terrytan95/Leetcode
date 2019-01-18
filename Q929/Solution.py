import re
class Solution:
    def numUniqueEmails(self, emails):
        split_emails = []
        for item in emails:
            split_emails.append(item.split("@"))
