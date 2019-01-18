import sys
class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)

        k = int((n1 + n2 + 1) / 2)

        l = 0
        r = n1

        while l < r:
            m1 = int(l + (r + l) / 2)
            m2 = k - m1
            if nums1[m1] < nums2[m2 - 1]:
                l = m1 + 1
            else:
                r = m1

        m1 = l
        m2 = k - l
        c1 = max(-sys.maxsize - 1 if m1 <= 0 else nums1[m1 - 1],
                 -sys.maxsize - 1 if m2 <= 0 else nums2[m2 - 1])

        if (n1 + n2) % 2 == 1:
            return c1

        c2 = min(sys.maxsize if m1 >= n1 else nums1[m1],
                 sys.maxsize if m2 >= n2 else nums2[m2])

        return (c1 + c2) / 2.0


test = Solution()
nums1 = [1, 2, 3]
nums2 = [4, 5, 6]
print(test.findMedianSortedArrays(nums1, nums2))
