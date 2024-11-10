#
# @lc app=leetcode id=253 lang=python3
#
# [253] Meeting Rooms II
#
# https://leetcode.com/problems/meeting-rooms-ii/description/
#
# algorithms
# Medium (41.81%)
# Total Accepted:    121.4K
# Total Submissions: 290.3K
# Testcase Example:  '[[0,30],[5,10],[15,20]]'
#
# Given an array of meeting time intervals consisting of start and end times
# [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
# required.
#
# Example 1:
#
#
# Input: [[0, 30],[5, 10],[15, 20]]
# Output: 2
#
# Example 2:
#
#
# Input: [[7,10],[2,4]]
# Output: 1
#
#
# Definition for an interval.


class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        if (not intervals):
            return 0

        starting = {}
        ending = {}
        lst = []
        room = 0
        need = 0
        
        for item in intervals:
            if item.start in starting:
                starting[item.start] += 1
            else:
                starting[item.start] = 1
                if item.start not in ending:
                    lst.append(item.start)
            if item.end in ending:
                ending[item.end] += 1
            else:
                ending[item.end] = 1
                if item.end not in starting:
                    lst.append(item.end)
                    
        lst.sort()
                
        for item in lst:
            if item in starting:
                room += starting[item]
            if item in ending:
                room -= ending[item]
            if room > need:
                need = room
            
        return need